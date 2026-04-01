// This file demonstrates how to handle frames in Selenium, 
// including switching to single and nested iframes and interacting with elements inside them.

package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FrameHandlingTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void singleFrameTest() {

        // IMPORTANT: Click correct tab
        driver.findElement(By.linkText("Single Iframe")).click();

        // Switch to frame
        driver.switchTo().frame(0);

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.sendKeys("Hello Frame");

        driver.switchTo().defaultContent();
    }

    @Test
    public void nestedFrameTest() {

        driver.findElement(By.linkText("Iframe with in an Iframe")).click();

        WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outerFrame);

        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(innerFrame);

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.sendKeys("Nested Frame");

        driver.switchTo().defaultContent();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}