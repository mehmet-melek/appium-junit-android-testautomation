package qa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qa.pages.LoginPage;
import qa.pages.ProductsPage;

public class ProductTests extends TestBase{
    LoginPage loginPage;
    ProductsPage productsPage;


    @BeforeEach
    public void setupMethod() {
        driver.closeApp();
        driver.launchApp();
        loginPage = new LoginPage(driver);
        productsPage = loginPage.directLogin();
    }

    @Test
    public void test_openProductDetailFromImage(){
        productsPage.validateOnProductPage()
                .openItemFromImage()
                .validateOnProductDetailPage();
    }

    @Test
    public void test_openProductDetailFromTitle(){
        productsPage.validateOnProductPage()
                .openItemFromTitle()
                .validateOnProductDetailPage();
    }

    @Test
    public void test_whenClickAddToCardButtonOfFirstItem_shouldChangeButtonNameToRemove(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .validateRemoveButton();
    }

    @Test
    public void test_whenClickAddToCardButtonOfFirstItem_shouldBeOneNumberOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .validateItemNumberOnCardIcon("1");
    }

    @Test
    public void test_whenClickAddToCardButtonOfFirstAndSecondItem_shouldBeTwoNumberOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .pressAddToCardButton()
                .validateItemNumberOnCardIcon("2");
    }

    @Test
    public void test_whenClickAddToCardButtonOfFirstAndSecondItem_thenClickRemoveButtonOfFirstItem_shouldBeOneNumberOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .pressAddToCardButton()
                .pressRemoveButton()
                .validateItemNumberOnCardIcon("1");
    }

    @Test
    public void test_whenClickAddToCardButtonOfFirstAndSecondItem_thenClickRemoveButtonOfFirstAndSecondItem_shouldBeNoneOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .pressAddToCardButton()
                .pressRemoveButton()
                .pressRemoveButton()
                .validateCardIconNumberIsEmpty();
    }






}
