// This file demonstrates how to handle different types of dropdowns in Selenium, 
// including single select, multi-select, and custom (non-select) dropdowns using Select class and WebElements.

package dropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

public class DropdownHandlingTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // ================== SELECT DROPDOWN ==================
    @Test(priority = 1)
    public void selectDropdownTest() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        // Locate dropdown
        WebElement oldStyleDropdown = driver.findElement(By.id("oldSelectMenu"));

        // Create Select object
        Select select = new Select(oldStyleDropdown);

        // Select by visible text
        select.selectByVisibleText("Purple");

        Thread.sleep(1000);

        // Select by value
        select.selectByValue("3"); // Yellow

        Thread.sleep(1000);

        // Select by index
        select.selectByIndex(5);

        Thread.sleep(1000);

        // Get all options
        List<WebElement> options = select.getOptions();
        System.out.println("Total options: " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    // ================== MULTI-SELECT ==================
    @Test(priority = 2)
    public void multiSelectDropdownTest() throws InterruptedException {

        // Use another site for multi-select
        driver.get("https://demoqa.com/select-menu");

        WebElement multiSelect = driver.findElement(By.id("cars"));

        Select select = new Select(multiSelect);

        // Check if multi-select
        System.out.println("Is Multi Select: " + select.isMultiple());

        // Select multiple values
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Saab");

        Thread.sleep(2000);

        // Deselect one
        select.deselectByVisibleText("Saab");

        Thread.sleep(1000);

        // Deselect all
        select.deselectAll();
    }

    // ================== NON-SELECT DROPDOWN ==================
    @Test(priority = 3)
    public void customDropdownTest() throws InterruptedException {

        driver.get("https://testautomationpractice.blogspot.com/");

        // Click dropdown
        WebElement dropdown = driver.findElement(By.id("country"));
        dropdown.click();

        // Get all options
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='country']/option"));

        for (WebElement option : options) {
            if (option.getText().equals("India")) {
                option.click();
                break;
            }
        }

        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}