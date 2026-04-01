// This file demonstrates how to perform various user interactions in Selenium using the Actions class 
// and Robot class, including mouse hover, double click, right click, drag and drop, keyboard actions, 
// and handling key events like ENTER.

package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ActionsTest {

    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        actions = new Actions(driver);
    }
    
    //mouse hover actions class
    @Test()
    public void mouseHoverTest() {
        // Mouse Hover (example menu - if available)
        WebElement hoverElement = driver.findElement(By.xpath("//button[text()='Point Me']"));
        actions.moveToElement(hoverElement).perform();
        System.out.println("Mouse Hover performed");
    }
    
    //double click actions class
    @Test()
    public void doubleClickTest() {
        WebElement field1 = driver.findElement(By.id("field1"));
        WebElement field2 = driver.findElement(By.id("field2"));

        field1.clear();
        field1.sendKeys("Hello");

        WebElement copyBtn = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        actions.doubleClick(copyBtn).perform();

        System.out.println("Double Click performed");
        System.out.println("Copied Text: " + field2.getAttribute("value"));
    }
    
    //right click actions class
    @Test()
    public void rightClickTest() {
        // Right click (context click) – using any element
        WebElement element = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        actions.contextClick(element).perform();

        System.out.println("Right Click performed");
    }
    
    //drag and drop actions class
    @Test()
    public void dragAndDropTest() {
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).perform();

        System.out.println("Drag and Drop performed");
    }
    
    //keyboard actions actions class
    @Test()
    public void keyboardActionsTest() {
        WebElement inputBox = driver.findElement(By.id("field1"));

        actions.click(inputBox)
                .keyDown(org.openqa.selenium.Keys.CONTROL)
                .sendKeys("a")   // select all
                .sendKeys("c")   // copy
                .keyUp(org.openqa.selenium.Keys.CONTROL)
                .perform();

        System.out.println("Keyboard Actions (CTRL+A, CTRL+C) performed");
    }
    
    //keyboard actions robot class
    @Test()
    public void robotClassTest() throws Exception {
        Robot robot = new Robot();

        // Press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Robot class ENTER key pressed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
