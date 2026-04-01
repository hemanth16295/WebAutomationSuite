// This file demonstrates how to handle file operations in Selenium, 
// including file upload using sendKeys and Robot class, and verifying file downloads.

package filehandling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileHandlingTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // ================== FILE UPLOAD USING SENDKEYS ==================
    @Test(priority = 1)
    public void uploadUsingSendKeys() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement upload = driver.findElement(By.id("file-upload"));

        //Provide your file path
        upload.sendKeys("D:\\Screenshot\\element.png");

        driver.findElement(By.id("file-submit")).click();

        System.out.println("File uploaded using sendKeys");
    }

    // ================== FILE UPLOAD USING ROBOT ==================
    @Test(priority = 2)
    public void uploadUsingRobot() throws Exception {

        driver.get("https://the-internet.herokuapp.com/upload");

        // DO NOT click file-upload input

        StringSelection ss = new StringSelection("D:\\Screenshot\\element.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Robot class file upload successfull");
    }

    // ================== FILE DOWNLOAD ==================
    @Test(priority = 3)
    public void fileDownload() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        // Click any file
        driver.findElement(By.linkText("some-file.txt")).click();

        Thread.sleep(3000); // wait for download

        // Check file exists
        File file = new File("C:\\Users\\HEMANTH.R\\Downloads\\Labour_Payroll_Summary_250321_071526.xls");

        if (file.exists()) {
            System.out.println("File downloaded successfully");
        } else {
            System.out.println("File download failed");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}