package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void waitUntilPageIsLoaded(int time){
    driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
  }

  void waitUntilElementClickable(WebElement element, int time) {
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void waitUntilElementVisible (By locator, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  void waitUntilElementVisible (WebElement element, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  void waitUntilElementInVisible (By locator, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  void waitUntilElementInVisible (WebElement element, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  void waitUntilAllElementsVisible (By locator, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  void waitUntilAllElementsVisible (List<WebElement> elements, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(elements));
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  void waitUntilAllElementsVisible (WebElement element, int time){
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(element));
    } catch (Exception e){
      e.printStackTrace();
    }
  }
  public void enterTextToField(WebElement element, String text) {
    element.click();
    element.clear();
    element.sendKeys(text);
  }

  public void selectInDropDown(WebElement element, String value){
    Select select = new Select(element);
    select.selectByValue(value);

  }

  public void checkIn (WebElement element){
    if ( !element.isSelected() ){
      element.click();
    }
  }



}
