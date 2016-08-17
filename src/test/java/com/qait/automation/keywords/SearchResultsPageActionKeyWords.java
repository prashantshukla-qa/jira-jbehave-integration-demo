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
		verifyPageTitleExact();
	}
	
	public void verfiySearchResults(String resultsCount){
		String valueResults = element("txt_resultsSearch").getText();
		Assert.assertEquals("No of results found doesn't match",resultsCount ,valueResults.replace(" results found for \"Music\"", ""));
	}

}