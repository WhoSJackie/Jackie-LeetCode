package com.wang.common.utils;

import com.wang.common.pojo.JdContent;
import com.wang.common.vo.Filters;
import com.wang.common.vo.LeetCodeRequestVo;
import com.wang.common.vo.Variables;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsoupUtil {

    private static final String API_URL = "https://api-gw.onebound.cn/taobao/";
    private static final String API_NAME = "item_search/";
    private static final String APP_KEY = "t3795770735";
    private static final String APP_SECRET = "0735014b";

    public static List<JdContent> getJDInfo(String keyWord) throws IOException {
        String url = "https://search.jd.com/Search?keyword="+keyWord;
        List<JdContent> targets = new ArrayList<>();
        Document document = Jsoup.parse(new URL(url), 30000);
        Element j_goodsList = document.getElementById("J_goodsList");
        Elements lis = j_goodsList.getElementsByTag("li");
        for (Element li : lis) {
            // System.out.println(li);
            String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String title = li.getElementsByClass("p-name").eq(0).text();
            String price = li.getElementsByClass("p-price").eq(0).text();
            JdContent target = new JdContent();
            target.setImg(img);
            target.setTitle(title);
            target.setPrice(price);
            targets.add(target);
        }

        targets.forEach(System.out::println);
        return targets;
    }

    public static String getHtmlByselenium(){
        System.setProperty("webdriver.edge.driver", "C:\\game\\edgedriver_win64\\msedgedriver.exe"); // 替换为ChromeDriver的路径
        EdgeOptions option = new EdgeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new EdgeDriver(option);
//        driver.get("https://s.taobao.com/search?page=1&q=%E7%9B%B8%E6%9C%BA&tab=all");
//        driver.findElement(By.id("username")).sendKeys("username");
//        driver.findElement(By.id("password")).sendKeys("password");
//        driver.findElement(By.cssSelector("button[type=submit]")).click();
        String pageSource = driver.getPageSource();
        driver.quit();
        System.out.println(pageSource);
        return pageSource;
    }

    public static void getTaoBaoAPI(String keyName){
        OkHttpClient client = new OkHttpClient();
        String url = API_URL+API_NAME+"?key="+APP_KEY+"&secret="+APP_SECRET+"&q="+keyName+"&start_price=0&end_price=0&page=1&cat=0&discount_only=&sort=&page_size=&seller_info=&nick=&ppath=&imgid=&filter=";
        Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);
        try {
            Response resp = call.execute();
            System.out.println(resp.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        getTaoBaoAPI("相机");

//        getJDInfo("java");
    }

}
