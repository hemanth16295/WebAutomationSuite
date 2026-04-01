// This file demonstrates parameterization in TestNG to run tests on different browsers, 
// allowing dynamic browser selection and executing a simple search operation.

package parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	WebDriver driver;
	
	@Parameters("browser")
	
	@BeforeTest
	public void beforeTest(String browser) {

	    System.out.println("Launching browser: " + browser);

	    if(browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver(); 
	    } else if(browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver(); 
	    }

	    driver.get("https://www.google.com/");
	}
	
	@Test
	public void test() {
		System.out.println("Test started");

	    driver.findElement(By.name("q")).sendKeys("books", Keys.ENTER);

	    System.out.println("Search completed");
	}
	
}
