package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends PageBase {
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public static final String validUserName = "standard_user";
    public static final String validPassword = "secret_sauce";
    public static final String invalidUserName = "invalid_username";
    public static final String invalidPassword = "invalid_password";
    private static final String errorMessage="Username and password do not match any user in this service.";


    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement userNameTextField;

    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement passwordTextField;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private MobileElement loginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    private MobileElement loginErrorMessage;

    public LoginPage enterUserName(String userName) {
        sendKeys(userNameTextField,userName);
        return this;
    }

    public LoginPage enterUserPassword(String password) {
        sendKeys(passwordTextField,password);
        return this;
    }

    public ProductsPage pressLoginButton() {
        click(loginButton);
        return new ProductsPage(driver);
    }

    public void validateErrorMessage() {
        Assertions.assertEquals(getElementText(loginErrorMessage),errorMessage);
    }

    public ProductsPage directLogin() {
        enterUserName(validUserName).enterUserPassword(validPassword).pressLoginButton();
        return new ProductsPage(driver);
    }

}
