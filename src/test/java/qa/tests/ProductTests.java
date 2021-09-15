package qa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.pages.LoginPage;
import qa.pages.ProductsPage;

class ProductTests extends TestBase{
    LoginPage loginPage;
    ProductsPage productsPage;


    @BeforeEach
    public void setupMethod() {
        loginPage = new LoginPage(driver);
        productsPage = loginPage.directLogin();
    }


    @Test
    @DisplayName("When click to product image, detail page should open")
    void test_openProductDetailFromImage(){
        productsPage.validateOnProductPage()
                .openItemFromImage()
                .validateOnProductDetailPage();
    }

    @Test
    @DisplayName("When click to product title, detail page should open")
    void test_openProductDetailFromTitle(){
        productsPage.validateOnProductPage()
                .openItemFromTitle()
                .validateOnProductDetailPage();
    }

    @Test
    @DisplayName("When click to 'Add To Cart' button, button name should change to 'Remove'")
    void test_whenClickAddToCardButtonOfFirstItem_shouldChangeButtonNameToRemove(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .validateRemoveButtonIsExist();
    }

    @Test
    @DisplayName("When 'Add To Cart' button is pressed once, the number on cart icon should be 1")
    void test_whenClickAddToCardButtonOfFirstItem_shouldBeOneNumberOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .validateItemNumberOnCardIcon("1");
    }

    @Test
    @DisplayName("When 'Add To Cart' button is pressed twice, the number on cart icon should be 2")
    void test_whenClickAddToCardButtonOfFirstAndSecondItem_shouldBeTwoNumberOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .pressAddToCardButton()
                .validateItemNumberOnCardIcon("2");
    }

    @Test
    @DisplayName("When 'Add To Cart' button is pressed twice then pressed 'Remove' button once, the number on cart icon should be 1")
    void test_whenClickAddToCardButtonOfFirstAndSecondItem_thenClickRemoveButtonOfFirstItem_shouldBeOneNumberOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .pressAddToCardButton()
                .pressRemoveButton()
                .validateItemNumberOnCardIcon("1");
    }

    @Test
    @DisplayName("When 'Add To Cart' button is pressed twice then pressed 'Remove' button twice, should be no numbers on the cart icon")
    void test_whenClickAddToCardButtonOfFirstAndSecondItem_thenClickRemoveButtonOfFirstAndSecondItem_shouldBeNoneOnTheCardIcon(){
        productsPage.validateOnProductPage()
                .pressAddToCardButton()
                .pressAddToCardButton()
                .pressRemoveButton()
                .pressRemoveButton()
                .validateCardIconNumberIsEmpty();
    }
}
