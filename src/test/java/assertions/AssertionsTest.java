// This file demonstrates the use of hard and soft assertions in TestNG, 
// including validation of page title and element visibility using Assert and SoftAssert.

package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    // ================== HARD ASSERT ==================
    @Test(priority = 1)
    public void hardAssertionTest() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Testing Practice";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Hard Assertion Passed");
    }

    // ================== HARD ASSERT (TRUE/FALSE) ==================
    @Test(priority = 2)
    public void hardAssertionBooleanTest() {

        boolean isDisplayed = driver.findElement(By.id("name")).isDisplayed();

        Assert.assertTrue(isDisplayed);

        System.out.println("Element is displayed");
    }

    // ================== SOFT ASSERT ==================
    @Test(priority = 3)
    public void softAssertionTest() {

        SoftAssert softAssert = new SoftAssert();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Wrong Title";

        softAssert.assertEquals(actualTitle, expectedTitle);

        boolean isDisplayed = driver.findElement(By.id("name")).isDisplayed();
        softAssert.assertTrue(isDisplayed);

        System.out.println("Soft assertions executed");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}