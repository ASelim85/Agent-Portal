package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletProcessPage extends PageBase {
    public  By walletProcessesLink = By.linkText("Wallet Processes");
    public  By WalletNum = By.id("walletNumber");
    public  By NIDNum = By.id("nationalId");
    public  By SubmitWalletNum = By.xpath("//button[@type='submit']");
    public WalletProcessPage(WebDriver driver) {
        super(driver);
    }

    public  void clickWalletProcess() {
        click(walletProcessesLink);
    }

    public  void addWalletNum() {
        setText(WalletNum, "01110693883");
    }

    public  void addNIDlastDigits() {
        setText(NIDNum, "03883");
    }

    public  void clickSubmitWalletNum() {
        click(SubmitWalletNum);
    }
}
