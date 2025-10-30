package com.wang.timetable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class EcommerceNewProductMonitor {

    // 配置文件路径
    private static final String CONFIG_FILE = "timetable-tool/src/main/resources/monitor_config.properties";
    private static final String KNOWN_PRODUCTS_FILE = "timetable-tool/src/main/resources/known_products.txt";

    // 存储已知产品ID
    private static Set<String> knownProducts = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public static void main(String[] args) {
        // 加载配置和已知产品
        loadConfig();
        loadKnownProducts();

        // 启动监控
        startMonitoring();

        // 添加关闭钩子保存已知产品
        Runtime.getRuntime().addShutdownHook(new Thread(EcommerceNewProductMonitor::saveKnownProducts));

    }

    private static void loadConfig() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
            System.out.println("配置加载成功");
        } catch (IOException ex) {
            System.err.println("无法加载配置文件，使用默认配置");
            createDefaultConfig();
        }
    }

    private static void createDefaultConfig() {
        Properties props = new Properties();
        props.setProperty("check.interval.minutes", "30");
        props.setProperty("website.jd.url", "https://www.jd.com/electronic");
        props.setProperty("website.jd.selector", ".product-item");
        props.setProperty("website.jd.id.attr", "data-sku");

        try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            props.store(output, "Ecommerce Monitor Configuration");
            System.out.println("已创建默认配置文件");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void createDefaultKnownProductsFile() {
        try (OutputStream output = new FileOutputStream(KNOWN_PRODUCTS_FILE)) {
            System.out.println("已创建默认配置文件");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void loadKnownProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(KNOWN_PRODUCTS_FILE))) {
            knownProducts.addAll(reader.lines().collect(Collectors.toSet()));
            System.out.println("已加载 " + knownProducts.size() + " 个已知产品");
        } catch (IOException e) {
            System.out.println("没有找到已知产品记录文件，将创建新文件");
            createDefaultKnownProductsFile();
        }
    }

    private static void saveKnownProducts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(KNOWN_PRODUCTS_FILE))) {
            for (String productId : knownProducts) {
                writer.write(productId);
                writer.newLine();
            }
            System.out.println("已保存 " + knownProducts.size() + " 个已知产品到文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startMonitoring() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        int interval = Integer.parseInt(props.getProperty("check.interval.minutes", "30"));
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 获取所有配置的网站
        Set<String> websites = props.stringPropertyNames().stream()
                .filter(name -> name.startsWith("website.") && name.endsWith(".url"))
                .map(name -> name.substring("website.".length(), name.lastIndexOf(".url")))
                .collect(Collectors.toSet());

        scheduler.scheduleAtFixedRate(() -> {
            websites.forEach(site -> {
                String url = props.getProperty("website." + site + ".url");
                String selector = props.getProperty("website." + site + ".selector");
                String idAttr = props.getProperty("website." + site + ".id.attr", "id");

                checkWebsite(site, url, selector, idAttr);
            });
        }, 0, interval, TimeUnit.MINUTES);

        System.out.println("监控服务已启动，每 " + interval + " 分钟检查一次");
    }

    private static void checkWebsite(String siteName, String url, String selector, String idAttr) {
        System.out.println("\n[" + new Date() + "] 检查 " + siteName + " (" + url + ")");

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                    .timeout(10000)
                    .get();

            Elements products = doc.select(selector);
            System.out.println("找到 " + products.size() + " 个产品");

            products.stream()
                    .filter(product -> {
                        String productId = product.attr(idAttr);
                        return !productId.isEmpty() && !knownProducts.contains(productId);
                    })
                    .forEach(product -> {
                        String productId = product.attr(idAttr);
                        String productName = extractProductName(product, siteName);
                        String productUrl = extractProductUrl(product, siteName);
                        String productPrice = extractProductPrice(product, siteName);

                        knownProducts.add(productId);
                        notifyNewProduct(siteName, productName, productPrice, productUrl, productId);
                    });

        } catch (IOException e) {
            System.err.println("[" + siteName + "] 监控失败: " + e.getMessage());
        }
    }

    private static String extractProductName(Element product, String siteName) {
        // 根据网站不同调整选择器
        switch (siteName.toLowerCase()) {
            case "jd":
                return product.select(".p-name").text();
            case "tmall":
                return product.select(".productTitle").text();
            default:
                return product.select("h3, h2, .title, .name").first() != null ?
                        product.select("h3, h2, .title, .name").first().text() : "未知产品";
        }
    }

    private static String extractProductUrl(Element product, String siteName) {
        Element link = product.select("a").first();
        if (link != null) {
            String href = link.attr("href");
            if (!href.startsWith("http")) {
                if (siteName.equalsIgnoreCase("jd") || siteName.equalsIgnoreCase("tmall")) {
                    return "https:" + href;
                } else {
                    return "https://" + siteName + href;
                }
            }
            return href;
        }
        return "#";
    }

    private static String extractProductPrice(Element product, String siteName) {
        switch (siteName.toLowerCase()) {
            case "jd":
                return product.select(".p-price").text();
            case "tmall":
                return product.select(".productPrice").text();
            default:
                return product.select(".price, .amount").first() != null ?
                        product.select(".price, .amount").first().text() : "价格未知";
        }
    }

    private static void notifyNewProduct(String siteName, String productName,
                                         String price, String url, String productId) {
        System.out.println("\n!!! 发现新产品 !!!");
        System.out.println("网站: " + siteName);
        System.out.println("产品ID: " + productId);
        System.out.println("名称: " + productName);
        System.out.println("价格: " + price);
        System.out.println("链接: " + url);
        System.out.println("时间: " + new Date());

        // 这里可以添加邮件通知、数据库存储等逻辑
        // sendEmailNotification(siteName, productName, price, url);
    }
}
