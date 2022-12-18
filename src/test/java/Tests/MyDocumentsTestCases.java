package Tests;


import Pages.KYCDocumentPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MyDocumentsTestCases extends TestBase {
    //    public MyDocumentsTestCases(WebDriver driver) {
//        super();
//    }
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 0, enabled = true)
    public void addNewKYCDoc() {
        login.LoginWithValidCredentials();
        myDocumentsPage.clickKYCManagementLink();
        myDocumentsPage.clickMyKYCDocsLink();
        softAssert.assertEquals(myDocumentsPage.getMyDocsPageTitle(), "My Documents");
        myDocumentsPage.clickAddKYCDocLink();
        softAssert.assertEquals(myDocumentsPage.getEnterWalletNumbTitle(), "Enter Wallet Number");
        myDocumentsPage.setMobileNumber();
        myDocumentsPage.clickSubmit();
        softAssert.assertEquals(myDocumentsPage.getCreateKYCTitle(), "Create KYC");
        myDocumentsPage.setRefNum();
        myDocumentsPage.setNID();
        myDocumentsPage.setNIDExpDate();
        myDocumentsPage.setFName();
        myDocumentsPage.setLName();
        myDocumentsPage.clickMartialStatus();
        myDocumentsPage.setEmail();
        softAssert.assertEquals(myDocumentsPage.getAddInfoTitle(), "Address Information");
        myDocumentsPage.setGovernorate();
        myDocumentsPage.setCity();
        myDocumentsPage.setAddress();
        softAssert.assertEquals(myDocumentsPage.getJobInfoTitle(), "Job Information");
        myDocumentsPage.setProfession();
        myDocumentsPage.setTitle();
        myDocumentsPage.setWorkEntName();
        myDocumentsPage.setWorkAddress();
        myDocumentsPage.setSourceOfIncome();
        myDocumentsPage.setMonthlyIncome();
        softAssert.assertEquals(myDocumentsPage.getAddInfTitle(), "Additional Information");
        myDocumentsPage.setPartner();
        myDocumentsPage.setTrxNature();
        myDocumentsPage.setwalletRegObjective();
        myDocumentsPage.clickCreate();
//        Assert.assertEquals(myDocumentsPage.getKYCDocumentTitle(), "KYC Document");
        softAssert.assertEquals(kYCDocumentPage.getKYCDocsTitle(), "KYC Document");
        softAssert.assertEquals(kYCDocumentPage.getPersonalInfoTitle(), "Personal Information");
        softAssert.assertEquals(kYCDocumentPage.getJobInfoTitle(), "Job Information");
        softAssert.assertEquals(kYCDocumentPage.getAddressInfoTxt(), "Address Information");
        softAssert.assertEquals(kYCDocumentPage.getAdditionalInfoTxt(), "Additional Information");
        softAssert.assertAll();

//        myDocumentsPage.getMyDocsPageTitle();
    }
}