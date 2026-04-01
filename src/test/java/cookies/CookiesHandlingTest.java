// This file demonstrates how to handle browser cookies in Selenium, 
// including retrieving, adding, and deleting cookies using WebDriver's cookie management methods.

package cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Set;

public class CookiesHandlingTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    // ================== GET ALL COOKIES ==================
    @Test(priority = 1)
    public void getAllCookies() {

        Set<Cookie> cookies = driver.manage().getCookies();

        System.out.println("Total Cookies: " + cookies.size());

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }
    }

    // ================== GET SPECIFIC COOKIE ==================
    @Test(priority = 2)
    public void getSpecificCookie() {

        Cookie cookie = driver.manage().getCookieNamed("AEC");

        if (cookie != null) {
            System.out.println("Cookie Found: " + cookie.getName());
        } else {
            System.out.println("Cookie NOT Found");
        }
    }

    // ================== ADD COOKIE ==================
    @Test(priority = 3)
    public void addCookie() {

        Cookie newCookie = new Cookie("testCookie", "12345");

        driver.manage().addCookie(newCookie);

        System.out.println("Cookie added");

        // verify
        Cookie cookie = driver.manage().getCookieNamed("testCookie");
        System.out.println("Added Cookie: " + cookie.getName());
    }

    // ================== DELETE SPECIFIC COOKIE ==================
    @Test(priority = 4)
    public void deleteCookie() {

        driver.manage().deleteCookieNamed("testCookie");

        System.out.println("Cookie deleted");
    }

    // ================== DELETE ALL COOKIES ==================
    @Test(priority = 5)
    public void deleteAllCookies() {

        driver.manage().deleteAllCookies();

        System.out.println("All cookies deleted");

        System.out.println("Remaining Cookies: " + driver.manage().getCookies().size());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
