package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class MYSMETestCases extends BaseTest {

    @Test(priority = 0, enabled = true)
    public void FilterwithMobileNumber() throws InterruptedException, IOException, AWTException {
        login.LoginWithValidCredentials();
        mySMEsPage.clickSMEs();
        mySMEsPage.clickMySMEs();
        Assert.assertTrue(mySMEsPage.isMYSMEDisplayed());
        Assert.assertEquals(mySMEsPage.getMySMEText(), "My SMEs");
        mySMEsPage.setMobileNumber("01111353830");
        mySMEsPage.clickShowResultBtn();
        mySMEsPage.clickExportList();
    }

    @Test(priority = 1, enabled = true)
    public void FilterwithName() throws InterruptedException, IOException, AWTException {
        login.LoginWithValidCredentials();
        mySMEsPage.clickSMEs();
        mySMEsPage.clickMySMEs();
        Assert.assertTrue(mySMEsPage.isMYSMEDisplayed());
        Assert.assertEquals(mySMEsPage.getMySMEText(), "My SMEs");
        mySMEsPage.setName();
        mySMEsPage.clickShowResultBtn();
        mySMEsPage.clickExportList();

    }

    @Test(priority = 2, enabled = true)
    public void FilterwithGovernrate() throws InterruptedException, IOException, AWTException {
        login.LoginWithValidCredentials();
        mySMEsPage.clickSMEs();
        mySMEsPage.clickMySMEs();
        Assert.assertTrue(mySMEsPage.isMYSMEDisplayed());
        Assert.assertEquals(mySMEsPage.getMySMEText(), "My SMEs");
        mySMEsPage.selectGovernorate();
        mySMEsPage.selectCity();
        mySMEsPage.clickShowResultBtn();
        mySMEsPage.clickExportList();


    }

    @Test(priority = 3, enabled = true)
    public void FilterwithStatus() throws InterruptedException, IOException, AWTException {
        login.LoginWithValidCredentials();
        mySMEsPage.clickSMEs();
        mySMEsPage.clickMySMEs();
        Assert.assertTrue(mySMEsPage.isMYSMEDisplayed());
        Assert.assertEquals(mySMEsPage.getMySMEText(), "My SMEs");
        mySMEsPage.selectStatus();
        mySMEsPage.clickShowResultBtn();
        mySMEsPage.clickExportList();

    }
}
