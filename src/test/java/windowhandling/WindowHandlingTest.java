// This file demonstrates how to handle multiple browser windows in Selenium, 
// including switching between parent and child windows, performing actions, and closing windows.

package windowhandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlingTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandlingTest() throws InterruptedException {

        // 1. Get parent window ID
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window ID: " + parentWindow);

        // 2. Click link to open new window
        driver.findElement(By.linkText("Click Here")).click();

        Thread.sleep(2000);

        // 3. Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("Total Windows: " + allWindows.size());

        // 4. Loop through windows and switch
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to Child Window");

                // Print text from child window
                String text = driver.findElement(By.tagName("h3")).getText();
                System.out.println("Child Window Text: " + text);

                // Close child window
                driver.close();
            }
        }

        // 5. Switch back to parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Back to Parent Window");

        String parentText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Parent Window Text: " + parentText);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
