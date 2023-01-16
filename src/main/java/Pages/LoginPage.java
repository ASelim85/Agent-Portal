package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public  By txtUsername = By.id("basic_login");
    public  By txtPassword = By.id("basic_password");
    public  By btnSignIn = By.xpath("//button[@type='submit']");
    public  By errorMSG = By.xpath("/html/body/div[2]/div");
    public  By txtOTP = By.id("basic_otp");
    public  By btnVerifyOTP = By.xpath("//button[@type='submit']");

    public void setUsername(String username) {
        setText(txtUsername, username);
    }

    public  void setPassword(String password) {
        setText(txtPassword, password);
    }

    public  void clickSignIn() {
        click(btnSignIn);
    }

    public  String GetErrorMSG() {
        waitElement(errorMSG);
        return action(errorMSG).getText();
    }

    public  void setOTP(String otp) {
        setText(txtOTP, otp);
    }

    public  void clickVerifyOTP() {
        click(btnVerifyOTP);
    }
}
