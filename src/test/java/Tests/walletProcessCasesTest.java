package Tests;

import org.testng.annotations.Test;

public class walletProcessCasesTest extends BaseTest {

    @Test(priority = 0, enabled = true)
    public void OpenWalletProcess() {
        login.LoginWithValidCredentials();
        wallProPage.clickWalletProcess();
        wallProPage.addWalletNum();
        wallProPage.addNIDlastDigits();
        wallProPage.clickSubmitWalletNum();
    }
}