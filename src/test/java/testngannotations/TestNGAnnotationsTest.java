// This file demonstrates the usage of different TestNG annotations, 
// showing the execution flow of test lifecycle methods like Before/After Suite, Test, Class, and Method.

package testngannotations;

import org.testng.annotations.*;

public class TestNGAnnotationsTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }
    
    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 2");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
}