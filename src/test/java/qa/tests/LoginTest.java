package qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pages.LoginPage;

public class LoginTest extends TestBase{

    LoginPage loginPage;


    @BeforeMethod
    public void setupMethod() {
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 0)
    public void loginWith_invalidUsername_invalidPassword(){
        loginPage.enterUserName(LoginPage.invalidUserName)
                .enterUserPassword(LoginPage.invalidPassword)
                .pressLoginPage();
        loginPage.validateErrorMessage();
    }


    @Test(priority = 1)
    public void loginWith_invalidUsername_validPassword(){
        loginPage.enterUserName(LoginPage.invalidUserName)
                .enterUserPassword(LoginPage.validPassword)
                .pressLoginPage();
        loginPage.validateErrorMessage();
    }

    @Test(priority = 2)
    public void loginWith_validUsername_invalidPassword(){
        loginPage.enterUserName(LoginPage.validUserName)
                .enterUserPassword(LoginPage.invalidPassword)
                .pressLoginPage();
        loginPage.validateErrorMessage();
    }

    @Test(priority = 3)
    public void loginWit_validUsername_validPassword(){
        loginPage.enterUserName(LoginPage.validUserName)
                .enterUserPassword(LoginPage.validPassword)
                .pressLoginPage();
    }
}
