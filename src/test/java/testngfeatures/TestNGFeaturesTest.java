// This file demonstrates various TestNG features such as priority, enabled/disabled tests, 
// invocation count, dependency between methods, and grouping of test cases.

package testngfeatures;

import org.testng.annotations.Test;

public class TestNGFeaturesTest {

    // ================== PRIORITY ==================
    @Test(priority = 1)
    public void login() {
        System.out.println("Login executed");
    }

    @Test(priority = 2)
    public void dashboard() {
        System.out.println("Dashboard executed");
    }

    @Test(priority = 3)
    public void logout() {
        System.out.println("Logout executed");
    }

    // ================== ENABLED ==================
    @Test(enabled = false)
    public void skippedTest() {
        System.out.println("This will NOT execute");
    }

    // ================== INVOCATION COUNT ==================
    @Test(invocationCount = 3)
    public void repeatTest() {
        System.out.println("Repeat Test executed");
    }

    // ================== DEPENDS ON METHODS ==================
    @Test
    public void startServer() {
        System.out.println("Server started");
    }

    @Test(dependsOnMethods = "startServer")
    public void runTest() {
        System.out.println("Test executed after server start");
    }

    @Test(dependsOnMethods = "runTest")
    public void stopServer() {
        System.out.println("Server stopped");
    }

    // ================== GROUPS ==================
    @Test(groups = "smoke")
    public void smokeTest1() {
        System.out.println("Smoke Test 1");
    }

    @Test(groups = "smoke")
    public void smokeTest2() {
        System.out.println("Smoke Test 2");
    }

    @Test(groups = "regression")
    public void regressionTest() {
        System.out.println("Regression Test");
    }
}