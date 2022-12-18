package Tests;


import Pages.MyDocumentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Tests.MyDocumentsTestCases;

public class KYCDocumentTestCases extends TestBase {

    MyDocumentsTestCases myDocumentsTestCases = new MyDocumentsTestCases();
//    MyDocumentsPage myDocumentsPage = new MyDocumentsPage();
    SoftAssert softAssert = new SoftAssert();
    @Test(priority = 0, enabled = true)
    public void submitKYCDocs() {
        myDocumentsTestCases.addNewKYCDoc();
        softAssert.assertEquals(kYCDocumentPage.CreateKYCTxt, "");
        Assert.assertEquals(myDocumentsPage.KYCDocumentTitle, "KYC Document");


//        myDocumentsPage.getMyDocsPageTitle();
    }
}