package com;

import com.pages.HomePage;
import com.pages.ProductPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTests extends TestBase {
    private HomePage homepage;
    private ProductPage productPage;

    @BeforeMethod(alwaysRun=true)
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
    }

    @Test(groups = "productPageTests")
    public void testUserCanAddProductToBasket() throws InterruptedException {
        homepage.waitUntilPageIsLoaded(10);
        homepage.selectBookSubmenu();
        productPage.waitUntilPageIsLoaded(10);
        homepage.selectFirstProductInList();
        productPage.addProductToBasket();
        productPage.successMessagesIsDisplayed();
    }
    @Test(groups = "productPageTests")
    public void testVerifyProductNameAndPriceInMessages() {
        homepage.waitUntilPageIsLoaded(10);
        homepage.selectBookSubmenu();
        String bookName = homepage.returnBookName();
        String bookPrice = homepage.returnBookPrice();
        homepage.selectFirstProductInList();
        productPage.addProductToBasket();
        String bookNameOnMessage = productPage.returnBookNameOnMessage();
        String bookPriceOnMessage = productPage.returnBookPriceOnMessage();
        Assert.assertEquals(bookName, bookNameOnMessage, "Book name in success message is not correct");
        Assert.assertEquals(bookPrice, bookPriceOnMessage, "Book price in success message is not correct");
    }

}