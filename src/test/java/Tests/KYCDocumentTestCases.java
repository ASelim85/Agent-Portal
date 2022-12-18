package Tests;

import Pages.DashboardPage;
import Pages.KYCDocumentPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KYCDocumentTestCases extends TestBase {
    static String phoneNumber = "01965545121";


    @Test(priority = 0, enabled = true)
    public static void AddNewKYC() throws InterruptedException {
        loginTestCases.LoginWithValidCredentials();
        Thread.sleep(2000);
//        driver.findElement(By.xpath(" //span[contains(@class, 'ant-menu-title-content') and contains(., 'KYC Management')]")).click();
        KYCDocumentPage.clickKyc();
        KYCDocumentPage.clickMyDoc();
        KYCDocumentPage.clickAddKyc();
        KYCDocumentPage.setTextNumber(phoneNumber);
        KYCDocumentPage.clickSubmit();

    }


}