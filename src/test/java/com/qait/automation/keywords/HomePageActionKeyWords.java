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

	public void verifyUserIsOnHomePage() {
		verifyPageTitleExact("Alexander Street");
	}

	public void clickSignInLink() {
		element("lnk_signIn").click();
		logMessage("Clicked on Sign In");
	}

	public void clickOnLinkToShowMenu() {
		if (element("lnk_hideNav").getText().equals("HIDE CONTENT")) {
			element("lnk_showNav").click();
		} else {
			logMessage("Search All Content menu is already visible");
		}
	}
	
	public void typeSearchTextToSearchResults(String searchText){
		element("inpt_searchBasic").sendKeys(searchText);
		logMessage("Typed "+searchText+" in basic search field");
	}

	public void clickSearchButton() {
		element("btn_goSearch").click();
	}

}
