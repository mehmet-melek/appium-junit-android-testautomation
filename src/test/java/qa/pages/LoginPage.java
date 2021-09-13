package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageBase {
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement userNameTextField;

    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement passwordTextField;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private MobileElement loginButton;

    public LoginPage enterUserName(String userName) {
        sendKeys(userNameTextField,userName);
        return this;
    }

    public LoginPage enterUserPassword(String password) {
        sendKeys(passwordTextField,password);
        return this;
    }

    public void pressLoginPage() {
        click(loginButton);
    }

}
