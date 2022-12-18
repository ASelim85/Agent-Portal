package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletProcessPage extends PageBase {
    public static By walletProcessesLink = By.linkText("Wallet Processes");
    public static By WalletNum = By.id("walletNumber");
    public static By NIDNum = By.id("nationalId");
    public static By SubmitWalletNum = By.xpath("//button[@type='submit']");

    public static By CashOut = By.className("_cashout-btn_187oc_87");

    public static By Amount = By.id("transactionAmount");

    public static By MPin = By.id("mPin");

    public static By Description = By.id("description");

    public static By VerifyOTP = By.className("_process-button_132ld_26");

    public static By MPin2 = By.id("mPin");
    public static By Otp = By.id("otp");
    public WalletProcessPage(WebDriver driver) {
        super(driver);
    }

    public static void clickWalletProcess() {
        click(walletProcessesLink);
    }

    public static void addWalletNum() {
        setText(WalletNum, "01110693883");
    }

    public static void addNIDlastDigits() {
        setText(NIDNum, "03883");
    }

    public static void clickSubmitWalletNum() {
        click(SubmitWalletNum);
    }

    public static void  clickCashOut (){click (CashOut);}

    public static void  AddAmount (){setText(Amount,"10000");}

    public static void SetMPin (){setText(MPin,"123457");}

    public static void AddDescription (){setText(Description,"Hello");}

    public static void clickVerifyOTP (){click(VerifyOTP);}

    public static void SetOTP (){setText(Otp,"261818");}



}
