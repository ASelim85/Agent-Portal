package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTestCases extends TestBase {
    static String Username = "agentuser5";
    static String Password = "P@ssw0rd";

    @Test(priority = 0, enabled = true)
    public void LoginWithValidCredentials() {
        loginPage.setUsername(Username);
        loginPage.setPassword(Password);
        loginPage.clickSignIn();
        loginPage.setOTP("245345");
        loginPage.clickVerifyOTP();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertEquals(dashboardPage.getDashBoardText(), "Dashboard");
    }

    @Test(priority = 1, enabled = true)
    public void LoginWithInValidCredentials() {
        loginPage.setUsername(Username);
        loginPage.setPassword("P@ssw0rd1");
        loginPage.clickSignIn();
        loginPage.GetErrorMSG();
        Assert.assertEquals(loginPage.GetErrorMSG(), "Invalid Login");
    }
}