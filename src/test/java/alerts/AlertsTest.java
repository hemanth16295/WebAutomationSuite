// This file demonstrates how to handle different types of alerts in Selenium, 
// including simple alerts, confirmation alerts, and prompt alerts, using Alert interface methods.

package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertsTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    @Test()
    public void simpleAlertTest() {
        // Click Simple Alert button
        driver.findElement(By.id("alertBtn")).click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        // Get text
        System.out.println("Simple Alert Text: " + alert.getText());

        // Accept alert
        alert.accept();
    }

    @Test()
    public void confirmAlertTest() {
        // Click Confirm Alert button
        driver.findElement(By.id("confirmBtn")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println("Confirm Alert Text: " + alert.getText());

        // Dismiss alert (Cancel)
        alert.dismiss();
    }

    @Test()
    public void promptAlertTest() {
        // Click Prompt Alert button
        driver.findElement(By.id("promptBtn")).click();

        Alert alert = driver.switchTo().alert();

        // Send text
        alert.sendKeys("Hemanth");

        // Accept alert
        alert.accept();

        System.out.println("Prompt Alert handled with input");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}