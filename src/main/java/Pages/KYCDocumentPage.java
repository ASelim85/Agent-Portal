package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KYCDocumentPage extends PageBase {
    public KYCDocumentPage(WebDriver driver) {
        super(driver);
    }
    static By KYCManagementLink1 = By.xpath("//li[@data-axis-test-id = 'KYC Management']");
    static By KYCManagementLink2 = By.xpath("//*[@data-axis-test-id = 'KYC Management']");
    static By KYCManagementLink3 = By.xpath("//li[@data-axis-test-id = 'KYC Management']/div[@role =' menuitem']");
    static By KYCManagementLink = By.xpath("*[@data-axis-test-id='KYC Management']/*[@role='menuitem']");
    //span[contains(@class, 'ant-menu-title-content') and contains(., 'KYC Management')]
    public static By myDocumentsLink = By.xpath("//a[@href='/my-kyc-documents']");

    public static By btnAddKYC = By.className("ant-btn-primary");

    public static By textNumber = By.id("walletNumber");

    public static By btnSubmit = By.className("ant-btn-primary");

    public static void clickKyc() {
//        WebElement KYCManagementLink = driver.findElement(By.xpath( "//class[@data-testid='KYC Management']"));
//        WebElement KYCManagementLink = driver.findElement(By.xpath("//*[@data-axis-test-id='KYC Management']/*[@role='menuitem']"));

//        KYCManagementLink.click();
        click(KYCManagementLink);
    }
    public static void clickMyDoc(){
       click(myDocumentsLink);
    }

   public static void clickAddKyc(){
        click(btnAddKYC);}

    public static void setTextNumber(String phoneNumber) {
        setText(textNumber , phoneNumber);
    }
    public static void clickSubmit() {
        click(btnSubmit);}

}
