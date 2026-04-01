// This file demonstrates how to handle a date picker in Selenium, 
// including selecting a specific month, year, and day, and retrieving the selected date value.

package datepicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePickerTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");
    }

    @Test
    public void selectDateTest() {

        // Click on date input field
        driver.findElement(By.id("datePickerMonthYearInput")).click();

        // Select Month
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        monthDropdown.sendKeys("August");

        // Select Year
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        yearDropdown.sendKeys("2026");

        // Select Day (15) - safer XPath
        driver.findElement(By.xpath(
            "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='15']"
        )).click();

        // Get selected date value
        String selectedDate = driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");

        System.out.println("Selected Date: " + selectedDate);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}