package com.qait.automation.keywords;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

/**
 * 
 * @author prashantshukla
 */
public class SearchResultsPageActionKeyWords extends GetPage {

	public SearchResultsPageActionKeyWords(WebDriver driver) {
		super(driver, "SearchPage");
	}

	public void verifyUserIsOnSearchResultsPage() {
		verifyPageTitleExact("Alexander Street");
	}

	public void verifySearchResultsFound(String noOfSearchResults) {
		if (element("txt_resultsSearch").getText().equals(noOfSearchResults)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

}