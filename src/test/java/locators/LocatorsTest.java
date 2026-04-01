// This file demonstrates different types of locators in Selenium, 
// including id, name, XPath, CSS selector, and tag name, to interact with web elements on a registration form.

package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocatorsTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://keralaproperty.in/member/register/");
        driver.manage().window().maximize();
    }

    @Test
    public void locatorsTest() {
        // ------------------ Id Locator ------------------
        WebElement name = driver.findElement(By.id("utitle"));
        name.sendKeys("HemanthR");
        System.out.println("Id Locator - Name entered");
        
        // ------------------ Name Locator ------------------
        WebElement email = driver.findElement(By.name("umail"));
        email.sendKeys("hemanth16295@gmail.com");
        System.out.println("Name Locator - Email entered");
        
        // ------------------ XPath Locator ------------------
        WebElement password = driver.findElement(By.xpath("//input[@id='memberpass']"));
        password.sendKeys("abcd@1234");
        System.out.println("XPath Locator - Password entered");
        
        // ------------------ Absolute XPath Locator ------------------
        WebElement password2 = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div/div[4]/div[1]/div/input"));
        password2.sendKeys("abcd@1234");
        System.out.println("Absolute XPath Locator - Password entered");
        
        // ------------------ XPath with dynamic changing value Locator ------------------
        WebElement confirmPassword = driver.findElement(By.xpath("//*[contains(@id,'repass')]"));
        confirmPassword.sendKeys("abcd@1234");
        System.out.println("XPath with dynamic changing value Locator - Confirm Password entered");
        
        // ------------------ CSS Selector Locator ------------------
        WebElement phone = driver.findElement(By.cssSelector("#umobile"));
        phone.sendKeys("1234");
        System.out.println("CSS Selector Locator - Phone entered");
        
        // ------------------ Link Text Locator ------------------
        //WebElement phone2 = driver.findElement(By.linkText("Sign in"));
        //phone2.sendKeys("1234");
        //System.out.println("Link Text Locator - Phone entered");
        
        // ------------------ Partial Link Text Locator ------------------
        //WebElement phon3 = driver.findElement(By.partialLinkText("Sign in"));
        //phone3.sendKeys("1234");
        //System.out.println("Partial Link Text Locator - Phone entered");
        
        // ------------------ CSS Selector Locator ------------------
        List<WebElement> allInputs = driver.findElements(By.tagName("input"));
        for (WebElement input : allInputs) {
            if ("Create Account".equals(input.getAttribute("value"))) {
                input.click(); // Click the button
                break;
            }
        }
        
    }
}
