package qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pages.LoginPage;

public class LoginTest extends TestBase{

    LoginPage loginPomPage;

    @BeforeMethod
    public void setupMethod() {
        loginPomPage = new LoginPage(driver);
    }

    @Test
    public void deneme(){
        loginPomPage.enterUserName("standard_user")
                .enterUserPassword("secret_sauce")
                .pressLoginPage();
    }
}
