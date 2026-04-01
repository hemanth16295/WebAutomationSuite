// This file demonstrates how to capture screenshots in Selenium, 
// including full page, specific element, and timestamp-based screenshots for better test reporting.

package screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    // ================== FULL PAGE SCREENSHOT ==================
    @Test()
    public void fullPageScreenshot() throws Exception {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\Screenshot\\fullpagescreenshot.png");

        FileHandler.copy(src, dest);

        System.out.println("Full page screenshot captured");
    }

    // ================== ELEMENT SCREENSHOT ==================
    @Test()
    public void elementScreenshot() throws Exception {

        WebElement element = driver.findElement(By.id("name"));

        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\Screenshot\\element.png");

        FileHandler.copy(src, dest);

        System.out.println("Element screenshot captured");
    }

    // ================== TIMESTAMP SCREENSHOT ==================
    @Test()
    public void timestampScreenshot() throws Exception {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File dest = new File("D:\\Screenshot\\screenshot_" + timestamp + ".png");

        FileHandler.copy(src, dest);

        System.out.println("Timestamp screenshot captured");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}