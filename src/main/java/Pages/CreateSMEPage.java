package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class CreateSMEPage extends PageBase {

    public CreateSMEPage(WebDriver driver) {
        super(driver);
    }
    String dataId = "//*[@data-axis-test-id=";

    public By txtMYSMEsTitle = By.xpath("//h1[@class='ant-typography' and text()='My SMEs']");

    public By SMEsLink = By.xpath(dataId+"'smes-link']");

    public By mySMEsLink = By.xpath("//*[@data-axis-test-id='my-smes-link']");

    public By addNewSME = By.xpath("//a[@href='/my-smes/create-sme']");

    public By txtBusinessName = By.xpath(dataId+"'client-name-in-english-input']");
    public By txtArabicBusinessName = By.xpath(dataId+"'client-name-in-arabic-input']");
    public By txtGovernorate = By.id("governorate");
    public By txtCity = By.id("city");
    public By txtAddress = By.xpath(dataId+"'address-input']");
    public By txtSelectedPlan = By.xpath(dataId+"'plan-input']");
    public By txtCommercialRegistrationNo = By.xpath(dataId+"'commercial-registration-number-input']");
    public By txtCommercialRegistrationIssuanceOffice = By.id("issuancePlaceCode");
    public By txtIndustryType = By.id("industryType");
    public By txtCompanysize = By.id("numOfEmployees");
    public By nameInEn = By.xpath(dataId+"'name-in-english-input']");
    public By nameInAr = By.xpath(dataId+"'name-in-arabic-input']");
    public By email = By.xpath(dataId+"'email-input']");
    public By phonenumber = By.xpath(dataId+"'mobile-number-input']");
    public By nationalid = By.xpath(dataId+"'national-id-input']");
    public By uploadNIDbtn = By.xpath(dataId+"'upload-attachment-FileCategoryType_NATIONAL_ID-button']");
    public By contractuploadbtn = By.xpath(dataId+"'upload-attachment-FileCategoryType_CONTRACT-button']");
    public By commericalreguploadbtn = By.xpath(dataId+"'upload-attachment-FileCategoryType_COMMERICAL_REG-button']");
    public By taxdocuploadbtn = By.xpath(dataId+"'upload-attachment-FileCategoryType_TAX_DOCS-button']");
    public By submitforreviewbtn = By.xpath("//*[@class='ant-btn ant-btn-primary']");
    public By txtOTPTittle = By.xpath("//div[@id=':rp:' and text()='OTP']");

    public  By txtOTP0 = By.xpath(dataId+"'otp-input-0']");
    public  By txtOTP1 = By.xpath(dataId+"'otp-input-1']");
    public  By txtOTP2 = By.xpath(dataId+"'otp-input-2']");
    public  By txtOTP3 = By.xpath(dataId+"'otp-input-3']");
    public  By txtOTP4 = By.xpath(dataId+"'otp-input-4']");
    public  By txtOTP5 = By.xpath(dataId+"'otp-input-5']");
    public  By btnOK = By.xpath("//span[.='OK']");


    public void clickSMEs() {
        click(SMEsLink);

    }

    public void clickMySMEs() {
        click(mySMEsLink);

    }

    public Boolean isMYSMEDisplayed() {
        waitElement(txtMYSMEsTitle);
        return action(txtMYSMEsTitle).isDisplayed();
    }

    public String getMySMEText() {
        waitElement(txtMYSMEsTitle);
        String mySMETitle = action(txtMYSMEsTitle).getText();
        return mySMETitle;
    }

    public void clickAddNewSME() {
        click(addNewSME);
    }

    public void setBusinessName(String BusinessName) {
        setText(txtBusinessName, BusinessName);
    }

    public void setArabicBusinessName(String ArabicBusinessName) {
        setText(txtArabicBusinessName, ArabicBusinessName);
    }

    public void selectGonvernorate() {
        WebElement governorate = driver.findElement(By.id("governorate"));
        governorate.click();
        By governValues = By.xpath("//*[@title='Cairo']");
        click(governValues);
    }

    public void selectCity() {
        WebElement city = driver.findElement(By.id("city"));
        city.click();
        By cityValues = By.xpath("//*[@title='Maadi']");
        click(cityValues);
    }

    public void setAddress(String Address) {
        setText(txtAddress, Address);

    }

    public void selectPlan() {
        WebElement plan = driver.findElement(By.id("planId"));
        plan.click();
        By planValues = By.xpath("//*[@title='Small Business']");
        click(planValues);
    }

    public void setCommercialRegistrationNo(String CommercialRegistrationNo) throws InterruptedException {
        setText(txtCommercialRegistrationNo, CommercialRegistrationNo);
        Thread.sleep(1000);

    }

    public void selectComRegIssOffice() throws InterruptedException {
        WebElement issuancePlaceOffice = driver.findElement(By.id("issuancePlaceCode"));

        issuancePlaceOffice.click();
        issuancePlaceOffice.sendKeys("Federation");
        issuancePlaceOffice.sendKeys(Keys.ENTER);
    }

    public void selectIndustryType() {
        WebElement industrytype = driver.findElement(By.id("industryType"));
        industrytype.click();
        By industrytypeValues = By.xpath("//*[@title='Fintech']");
        click(industrytypeValues);
    }

    public void selectCompanysize() {
        WebElement companysize = driver.findElement(By.id("numOfEmployees"));
        companysize.click();
        By companysizeValues = By.xpath("//*[@title='10 - 50']");
        click(companysizeValues);
    }

    public void setNameInEN() {
        setText(nameInEn, "Test");

    }

    public void setNameInAR() {
        setText(nameInAr, "تست");
    }

    public void setEmail() {
        setText(email, "ahesham@axisapp.com");
    }

    public void setMobileNumber(String s) {
        setText(phonenumber, "01111353830");
    }

    public void setNationalID() {
        setText(nationalid, "29401010602012");
    }

    public void uploadNID() throws IOException, AWTException, InterruptedException {
        click(uploadNIDbtn);
        Thread.sleep(1000);
        Robot rb = new Robot();

        StringSelection str = new StringSelection("C:\\Users\\amohamed\\Pictures\\dashboard 2_LI.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

    public void setUploadContract() throws IOException, AWTException, InterruptedException {
        click(contractuploadbtn);
        Thread.sleep(1000);
        Robot rb = new Robot();

        StringSelection str = new StringSelection("C:\\Users\\amohamed\\Pictures\\dashboard 2_LI.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

    public void setUploadCommericalreg() throws IOException, AWTException, InterruptedException {
        click(commericalreguploadbtn);
        Thread.sleep(1000);
        Robot rb = new Robot();

        StringSelection str = new StringSelection("C:\\Users\\amohamed\\Pictures\\dashboard 2_LI.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

   public void setUploadTaxdoc() throws IOException, AWTException, InterruptedException {
        click(taxdocuploadbtn);
       Thread.sleep(1000);
        Robot rb = new Robot();

       StringSelection str = new StringSelection("C:\\Users\\amohamed\\Pictures\\dashboard 2_LI.jpg");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

       rb.keyRelease(KeyEvent.VK_CONTROL);
       rb.keyRelease(KeyEvent.VK_V);

       rb.keyPress(KeyEvent.VK_ENTER);
       rb.keyRelease(KeyEvent.VK_ENTER);
      Thread.sleep(1000);
    }



    public void clicksubmitforreview() {
        click(submitforreviewbtn);
    }
    public Boolean isOTPDisplayed() {
        waitElement(txtOTPTittle);
        return action(txtOTPTittle).isDisplayed();
    }
    public String getOTPTittleText() {
        waitElement(txtOTPTittle);
        String OTPTittle = action(txtOTPTittle).getText();
        return OTPTittle;
    }
    public void setOTP(String otp) {
        setText(txtOTP0, otp);
    }
    public void setOTP1(String otp) {
        setText(txtOTP1, otp);
    }
    public void setOTP2(String otp) {
        setText(txtOTP2, otp);
    }
    public void setOTP3(String otp) {
        setText(txtOTP3, otp);
    }
    public void setOTP4(String otp) {
        setText(txtOTP4, otp);
    }
    public void setOTP5(String otp) {
        setText(txtOTP5, otp);
    }

    public void clickOK() {
        click(btnOK);
    }

}






