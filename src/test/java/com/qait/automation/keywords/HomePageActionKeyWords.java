package com.qait.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

/**
 * 
 * @author prashantshukla
 */
public class HomePageActionKeyWords extends GetPage {

	public HomePageActionKeyWords(WebDriver driver) {
		super(driver, "LoginPage");
	}

	public void verifyUserIsOnLoginPage() {
		verifyPageTitleExact("Alexander Street");
	}
	
	public void clickSignInLink(){
		element("lnk_signIn").click();
		logMessage("Clicked on Sign In");
	}
	
}
