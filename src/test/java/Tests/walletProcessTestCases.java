package Tests;

import Pages.WalletProcessPage;
import org.testng.annotations.Test;

public class walletProcessTestCases extends TestBase {

    @Test(priority = 0, enabled = true)
    public void OpenWalletProcess() {
        login.LoginWithValidCredentials();
        wallProPage.clickWalletProcess();
        wallProPage.addWalletNum();
        wallProPage.addNIDlastDigits();
        wallProPage.clickSubmitWalletNum();
    }
}