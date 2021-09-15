package qa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qa.pages.LoginPage;

class LoginTests extends TestBase{

    LoginPage loginPage;

    @BeforeEach
    public void setupMethod() {
        loginPage = new LoginPage(driver);
    }

    @Test
    void loginWith_invalidUsername_invalidPassword(){
        loginPage.enterUserName(LoginPage.invalidUserName)
                .enterUserPassword(LoginPage.invalidPassword)
                .pressLoginButton();
        loginPage.validateErrorMessage();
    }

    @Test
    void loginWith_invalidUsername_validPassword(){
        loginPage.enterUserName(LoginPage.invalidUserName)
                .enterUserPassword(LoginPage.validPassword)
                .pressLoginButton();
        loginPage.validateErrorMessage();
    }

    @Test
    void loginWith_validUsername_invalidPassword(){
        loginPage.enterUserName(LoginPage.validUserName)
                .enterUserPassword(LoginPage.invalidPassword)
                .pressLoginButton();
        loginPage.validateErrorMessage();
    }

    @Test
    void loginWit_validUsername_validPassword(){
        loginPage.enterUserName(LoginPage.validUserName)
                .enterUserPassword(LoginPage.validPassword)
                .pressLoginButton()
                .validateOnProductPage();
    }
}
