package qa.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;


public class LoginPage extends BasePage{

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }


    MobileBy usernameTxtFld = new MobileBy.ByAccessibilityId("test-Username");
    MobileBy passwordTxtFld = new MobileBy.ByAccessibilityId("test-Password");
    MobileBy loginBtn = new MobileBy.ByAccessibilityId("test-LOGIN");


    public LoginPage enterUserName(String userName) {
        sendKeys(usernameTxtFld,userName);
        return this;
    }

    public LoginPage enterUserPassword(String password) {
        sendKeys(passwordTxtFld,password);
        return this;
    }

    public void pressLoginPage() {
        click(loginBtn);
    }

}
