package qa.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pages.LoginPage;

public class Tests extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void setupMethod() {
        loginPage = new LoginPage(driver);
    }


    @Test(description = "Verify that a user can login to the application with valid credentials")
    public void testValidLogin() {
        loginPage.enterUserName("standard_user")
                .enterUserPassword("secret_sauce")
                .pressLoginPage();
    }

}


