package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Page{

    @FindBy(css = ".btn-add-to-basket")
    WebElement addToBasketButton;

    @FindBy(css = ".alert.alert-safe.alert-noicon")
    List<WebElement> successMessageList;

    @FindBy(css=".alertinner strong")
    List<WebElement> getSuccessMsgInnerTextList;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToBasket() {
        addToBasketButton.click();

    }

    public Boolean successMessagesIsDisplayed() {
        return successMessageList.size() == 3;
    }

    public String returnBookNameOnMessage() {
        return getSuccessMsgInnerTextList.get(0).getText();
    }

    public String returnBookPriceOnMessage() {
        return getSuccessMsgInnerTextList.get(2).getText();
    }
}