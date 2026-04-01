// This file demonstrates how to handle web tables in Selenium, 
// including counting rows and columns, retrieving specific cell data, 
// iterating through table data, and applying conditions to extract required information.

package tables;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class WebTableTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    // ================== COUNT ROWS & COLUMNS ==================
    @Test(priority = 1)
    public void countRowsColumns() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));

        System.out.println("Total Rows: " + rows.size());
        System.out.println("Total Columns: " + columns.size());
    }

    // ================== GET SPECIFIC CELL DATA ==================
    @Test(priority = 2)
    public void getCellData() {

        String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]/td[2]")).getText();

        System.out.println("Cell Data: " + data);
    }

    // ================== PRINT ALL TABLE DATA ==================
    @Test(priority = 3)
    public void printAllData() {

        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();

        for (int i = 2; i <= rows; i++) {   // start from 2 (skip header)
            for (int j = 1; j <= cols; j++) {

                String data = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[" + j + "]"))
                        .getText();

                System.out.print(data + "  |  ");
            }
            System.out.println();
        }
    }

    // ================== CONDITIONAL DATA ==================
    @Test(priority = 4)
    public void findBookByAuthor() {

        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();

        for (int i = 2; i <= rows; i++) {

            String author = driver.findElement(
                    By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[2]"))
                    .getText();

            if (author.equals("Mukesh")) {

                String bookName = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[1]"))
                        .getText();

                System.out.println("Book by Mukesh: " + bookName);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}