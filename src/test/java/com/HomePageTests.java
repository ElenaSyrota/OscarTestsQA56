package com;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;

public class HomePageTests extends TestBase {

  private HomePage homepage;

  @BeforeMethod(alwaysRun=true)
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test(groups = "HomePage")
  public void testHomePageHasATitle() {

    Assert.assertEquals(driver.getTitle(), "Oscar - Sandbox");
  }
  @Test(groups = "HomePage")
  public void testHomePageHasLoginLink() {

    homepage.waitUntilPageIsLoaded(10);
    homepage.isLoginLinkDisplayed();

  }
  @Test(groups = "HomePage")
  public void testUserCanChangeLanguage() throws InterruptedException {
    String lang="ru";
    homepage.waitUntilPageIsLoaded(10);
    homepage.selectLanguageInDropDown(lang);
    //Thread.sleep(5000);
    homepage.isLanguageChanged(lang);
  }


}
