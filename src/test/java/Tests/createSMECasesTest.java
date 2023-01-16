package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class createSMECasesTest extends BaseTest {

    String BusinessName = "Disney Land";
    String ArabicBusinessName = "ديزني لاند";

    String Governrate = "Cairo";

    String city = "maadi";

    String Address = "التجمع الخامس-القاهرة الجديدة";

    // String Plan = "Micro Business";
    String CommercialRegistrationNo = "20202";


    @Test(priority = 0, enabled = true)
    public void OpenMYSMEs() throws InterruptedException, IOException, AWTException {
        login.LoginWithValidCredentials();
        createSMEPage.clickSMEs();
        createSMEPage.clickMySMEs();
        Assert.assertTrue(createSMEPage.isMYSMEDisplayed());
        Assert.assertEquals(createSMEPage.getMySMEText(), "My SMEs");
        createSMEPage.clickAddNewSME();
        createSMEPage.uploadNID();
        createSMEPage.setUploadContract();
        createSMEPage.scrollDownToElement();
        createSMEPage.setUploadCommericalreg();
        createSMEPage.setUploadTaxdoc();
        createSMEPage.scrollUpToElement();
        createSMEPage.setBusinessName(BusinessName);
        createSMEPage.setArabicBusinessName(ArabicBusinessName);
        createSMEPage.selectGonvernorate();
        createSMEPage.selectCity();
        createSMEPage.setAddress(Address);
        createSMEPage.selectPlan();
        createSMEPage.setCommercialRegistrationNo(CommercialRegistrationNo);
        createSMEPage.selectComRegIssOffice();
        createSMEPage.selectIndustryType();
        createSMEPage.selectCompanysize();
        createSMEPage.setNameInEN();
        createSMEPage.setNameInAR();
        createSMEPage.setEmail();
        createSMEPage.setMobileNumber("01111353830");
        createSMEPage.setNationalID();
        createSMEPage.scrollUpToElement();
        createSMEPage.clicksubmitforreview();
        Assert.assertTrue(createSMEPage.isOTPDisplayed());
        Assert.assertEquals(createSMEPage.getOTPTittleText(), "OTP");
        createSMEPage.setOTP("2");
        createSMEPage.setOTP1("4");
        createSMEPage.setOTP2("5");
        createSMEPage.setOTP3("3");
        createSMEPage.setOTP4("4");
        createSMEPage.setOTP5("5");
        createSMEPage.clickOK();
    }
}

