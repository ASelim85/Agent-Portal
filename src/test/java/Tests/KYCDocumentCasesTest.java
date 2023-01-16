package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class KYCDocumentCasesTest extends BaseTest {

    MyDocumentsCasesTest myDocumentsTestCases = new MyDocumentsCasesTest();
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