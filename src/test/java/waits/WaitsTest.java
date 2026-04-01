// This file demonstrates different types of waits in Selenium, 
// including implicit wait, explicit wait, and fluent wait to handle dynamic web elements effectively.

package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitsTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // ================== IMPLICIT WAIT ==================
    @Test(priority = 1)
    public void implicitWaitTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        // Selenium will wait up to 10 seconds automatically
        WebElement element = driver.findElement(By.id("name"));

        element.sendKeys("Implicit Wait");
        System.out.println("Implicit Wait executed");
    }

    // ================== EXPLICIT WAIT ==================
    @Test(priority = 2)
    public void explicitWaitTest() {

        driver.get("https://testautomationpractice.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until element is visible
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("name"))
        );

        element.sendKeys("Explicit Wait");
        System.out.println("Explicit Wait executed");
    }

    // ================== FLUENT WAIT ==================
    @Test(priority = 3)
    public void fluentWaitTest() {

        driver.get("https://testautomationpractice.blogspot.com/");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))        // total wait time
                .pollingEvery(Duration.ofSeconds(2))        // check every 2 sec
                .ignoring(NoSuchElementException.class);    // ignore exception

        WebElement element = wait.until(driver ->
                driver.findElement(By.id("name"))
        );

        element.sendKeys("Fluent Wait");
        System.out.println("Fluent Wait executed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}