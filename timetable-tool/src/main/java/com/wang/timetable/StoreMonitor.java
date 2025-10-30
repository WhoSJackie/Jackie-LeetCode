package com.wang.timetable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class StoreMonitor {

    // 存储已知产品，用于比较是否有新产品
    private static Set<String> knownProducts = ConcurrentHashMap.newKeySet();

    // 要监控的电商网站URL和产品选择器
    private static final Map<String, String> WEBSITES = new HashMap<String, String>() {
        {
        put("京东电子","https://www.jd.com/electronic");
        put("天猫数码","https://www.tmall.com/digital");
        put("亚马逊科技","https://www.amazon.com/electronics");
    }};

    // 对应的产品选择器(根据实际网站结构调整)
    private static final Map<String, String> SELECTORS = new HashMap<String, String>(){
        {
        put("京东电子",".product-item");
        put("天猫数码",".product");
        put("亚马逊科技",".s-result-item");
    }};

    public static void main(String[] args) {
        // 初始加载已知产品
        loadKnownProducts();

        // 启动监控服务
        startMonitoring();
    }

    private static void loadKnownProducts() {
        // 这里可以从文件或数据库加载之前已知的产品
        // 模拟加载一些初始产品
        knownProducts.addAll(Arrays.asList(
                "product-12345",
                "product-67890",
                "item-abc123"
        ));
        System.out.println("已加载 " + knownProducts.size() + " 个已知产品");
    }

    private static void startMonitoring() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(WEBSITES.size());

        // 为每个网站创建一个监控任务
        WEBSITES.forEach((name, url) -> {
            scheduler.scheduleAtFixedRate(() -> {
                checkForNewProducts(name, url, SELECTORS.get(name));
            }, 0, 30, TimeUnit.MINUTES); // 每30分钟检查一次
        });

        System.out.println("监控服务已启动，正在监控 " + WEBSITES.size() + " 个网站...");
    }

    private static void checkForNewProducts(String siteName, String url, String selector) {
        try {
            System.out.println("\n[" + siteName + "] 开始检查新产品...");

            // 获取网页内容
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            // 提取产品元素
            Elements products = doc.select(selector);

            // 分析每个产品
            for (Element product : products) {
                String productId = extractProductId(product, siteName);
                String productName = extractProductName(product, siteName);
                String productUrl = extractProductUrl(product, siteName);
                String productPrice = extractProductPrice(product, siteName);

                if (productId != null && !knownProducts.contains(productId)) {
                    // 发现新产品
                    knownProducts.add(productId);
                    onNewProductFound(siteName, productName, productPrice, productUrl);
                }
            }

        } catch (IOException e) {
            System.err.println("[" + siteName + "] 监控失败: " + e.getMessage());
        }
    }

    private static String extractProductId(Element product, String siteName) {
        // 根据不同的网站提取产品唯一ID
        switch (siteName) {
            case "京东电子":
                return product.attr("data-sku");
            case "天猫数码":
                return product.attr("data-id");
            case "亚马逊科技":
                return product.attr("data-asin");
            default:
                return product.id(); // 默认使用元素ID
        }
    }

    private static String extractProductName(Element product, String siteName) {
        // 根据不同的网站提取产品名称
        switch (siteName) {
            case "京东电子":
                return product.select(".p-name").text();
            case "天猫数码":
                return product.select(".productTitle").text();
            case "亚马逊科技":
                return product.select("h2 a span").text();
            default:
                return product.select(".name").text();
        }
    }

    private static String extractProductUrl(Element product, String siteName) {
        // 根据不同的网站提取产品URL
        switch (siteName) {
            case "京东电子":
                return "https:" + product.select(".p-img a").attr("href");
            case "天猫数码":
                return "https:" + product.select(".productImg").attr("href");
            case "亚马逊科技":
                return product.select("h2 a").attr("href");
            default:
                return product.select("a").attr("href");
        }
    }

    private static String extractProductPrice(Element product, String siteName) {
        // 根据不同的网站提取产品价格
        switch (siteName) {
            case "京东电子":
                return product.select(".p-price").text();
            case "天猫数码":
                return product.select(".productPrice").text();
            case "亚马逊科技":
                return product.select(".a-price-whole").text();
            default:
                return product.select(".price").text();
        }
    }

    private static void onNewProductFound(String siteName, String productName,
                                          String price, String url) {
        // 这里可以实现通知逻辑，如发送邮件、短信或保存到数据库
        System.out.println("\n!!! 发现新产品 !!!");
        System.out.println("网站: " + siteName);
        System.out.println("名称: " + productName);
        System.out.println("价格: " + price);
        System.out.println("链接: " + url);
        System.out.println("时间: " + new Date());

        // 示例：发送邮件通知
        // sendEmailNotification(siteName, productName, price, url);
    }

    // 示例邮件发送方法
    /*
    private static void sendEmailNotification(String siteName, String productName,
                                           String price, String url) {
        // 实现邮件发送逻辑
        // 可以使用JavaMail API或其他邮件服务
    }
    */
}
