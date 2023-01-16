package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Name;

public class MYSMEsPage extends PageBase {
    public MYSMEsPage(WebDriver driver) {
        super(driver);
    }

     String dataId = "//*[@data-axis-test-id=";
    public  By txtMYSMEsTitle = By.xpath("//h1[@class='ant-typography' and text()='My SMEs']");
    public  By SMEsLink = By.xpath(dataId + "'smes-link']");
    public  By mySMEsLink = By.xpath(dataId + "'my-smes-link']");
    public  By mobileNumberfield = By.xpath("//input[@id= 'mobileNo']");

    public  By name = By.xpath("//input[@id= 'name']");

    public By txtGovernorate = By.id("governorate");

    public By txtCity = By.id("city");
     By statusValues = By.xpath("//*[@title='Pending']");
    public  By txtStatus = By.id("status");

    public  By showResultBTN = By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-btn-background-ghost']");

    public  By exportListBTN = By.xpath("//span[@class='ant-typography _downloadButtonText_f8kqm_29']");

    public  void clickSMEs() {
        click(SMEsLink);

    }

    public  void clickMySMEs() {
        click(mySMEsLink);

    }

    public  Boolean isMYSMEDisplayed() {
        waitElement(txtMYSMEsTitle);
        return action(txtMYSMEsTitle).isDisplayed();
    }

    public  String getMySMEText() {
        waitElement(txtMYSMEsTitle);
        String mySMETitle = action(txtMYSMEsTitle).getText();
        return mySMETitle;
    }

    public  void setMobileNumber(String mobileNumber) throws InterruptedException {
        setText(mobileNumberfield, "01111353830");
    }


    public  void clickShowResultBtn() {
        click(showResultBTN);
    }

    public  void clickExportList() {
        click(exportListBTN);

    }

    public  void setName() {
        setText(name, "amira");

    }

    public  void selectGovernorate() {
        WebElement governorate = driver.findElement(By.id("governorate"));
        governorate.click();
        By governValues = By.xpath("//*[@title='Cairo']");
        click(governValues);
    }

    public  void selectCity() {
        WebElement city = driver.findElement(By.id("city"));
        city.click();
        By cityValues = By.xpath("//*[@title='Maadi']");
        click(cityValues);
    }

    public  void selectStatus() {
        WebElement status = driver.findElement(By.id("status"));
        status.click();
//        By status = By.id("status");
//        click(txtStatus);
//        By statusValues = By.xpath("//*[@title='Pending']");
        setStatus("Pending");
    }

    public  void setStatus(String status){
        click(statusValues);

    }
}

