package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(id="login_link")
  WebElement loginLink;

  @FindBy(css="select[name='language']")
  WebElement languageSelect;

  @FindBy(xpath="//button[@class='btn btn-default']")
  WebElement submitButton;

  @FindBy(css=".dropdown-submenu")
  WebElement booksSubmenu;

  @FindBy(className=".product_pod")
  List<WebElement> productList;

  @FindBy(css=".product_pod h3")
  List<WebElement> productNameList;

  @FindBy(css=".product_color")
  List<WebElement> productPriceList;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public Boolean isLoginLinkDisplayed() {
    return loginLink.isDisplayed();
  }
  public void selectLanguageInDropDown(String value){
    selectInDropDown(languageSelect, value);
    submitButton.click();
  }

  public Boolean isLanguageChanged(String value) {
    return  driver.getCurrentUrl().contains(value);
  }

  public void selectBookSubmenu() {
  booksSubmenu.click();
  }

  public void selectFirstProductInList() {
    productList.get(0).click();
  }

  public String returnBookName() {
    return productNameList.get(0).getText();
  }

  public String returnBookPrice() {
    return productPriceList.get(0).getText();
  }
}
