// This file demonstrates how to validate network-related aspects in Selenium, 
// including checking HTTP response codes, verifying current URL, and identifying broken links on a webpage.

package network;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class NetworkResponseTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    // ================== GET RESPONSE CODE ==================
    @Test(priority = 1)
    public void getResponseCode() throws Exception {

        String url = "https://testautomationpractice.blogspot.com/";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        System.out.println("Response Code: " + responseCode);

        if (responseCode == 200) {
            System.out.println("Valid URL");
        } else {
            System.out.println("Invalid URL");
        }
    }

    // ================== VERIFY CURRENT PAGE URL ==================
    @Test(priority = 2)
    public void verifyCurrentURL() {

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);

        if (currentUrl.contains("blogspot")) {
            System.out.println("URL verification PASSED");
        } else {
            System.out.println("URL verification FAILED");
        }
    }

    // ================== CHECK BROKEN LINKS ==================
    @Test(priority = 3)
    public void checkBrokenLinks() throws Exception {

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links: " + links.size());

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(url + " --> Broken Link (" + responseCode + ")");
                } else {
                    System.out.println(url + " --> Valid Link (" + responseCode + ")");
                }

            } catch (Exception e) {
                System.out.println(url + " --> Error");
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
