package com.qait.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

/**
 * 
 * @author prashantshukla
 */
public class SearchResultsPageActionKeyWords extends GetPage {

	public SearchResultsPageActionKeyWords(WebDriver driver) {
		super(driver, "LoginPage");
	}

	public void verifyUserIsOnSearchResultsPage() {
		verifyPageTitleExact("Alexander Street");
	}

}
