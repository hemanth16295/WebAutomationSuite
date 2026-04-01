// This file demonstrates how to use JavaScriptExecutor in Selenium to perform actions 
// like scrolling, clicking, sending text, and highlighting elements when standard methods are not sufficient.

package javascript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class JavaScriptExecutorTest {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    // ================== SCROLL DOWN ==================
    @Test(priority = 1)
    public void scrollPage() throws InterruptedException {

        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(2000);

        System.out.println("Scrolled down");
    }

    // ================== SCROLL TO ELEMENT ==================
    @Test(priority = 2)
    public void scrollToElement() throws InterruptedException {

        WebElement element = driver.findElement(By.id("name"));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

        System.out.println("Scrolled to element");
    }

    // ================== CLICK USING JS ==================
    @Test(priority = 3)
    public void clickUsingJS() {

        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));

        js.executeScript("arguments[0].click();", button);

        System.out.println("Clicked using JS");
    }

    // ================== SEND TEXT USING JS ==================
    @Test(priority = 4)
    public void sendKeysUsingJS() {

        WebElement input = driver.findElement(By.id("name"));

        js.executeScript("arguments[0].value='Hemanth';", input);

        System.out.println("Entered text using JS");
    }

    // ================== HIGHLIGHT ELEMENT ==================
    @Test(priority = 5)
    public void highlightElement() throws InterruptedException {

        WebElement element = driver.findElement(By.id("name"));

        js.executeScript("arguments[0].style.border='3px solid red'", element);

        Thread.sleep(2000);

        System.out.println("Element highlighted");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}