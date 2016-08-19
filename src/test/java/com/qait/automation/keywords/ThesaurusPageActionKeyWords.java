package com.qait.automation.keywords;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class ThesaurusPageActionKeyWords extends GetPage {

	WebDriver driver;

	public ThesaurusPageActionKeyWords(WebDriver driver) {
		super(driver, "ThesaurusPage");
		this.driver = driver;
	}

	public void searchTerm(String value) {
		wait.hardWait(5);
		element("inp_search").sendKeys(value + Keys.ENTER);
		logMessage("User enters "+value+" in search input");
	}
	
	public void verifySearchResult(){
		wait.hardWait(5);
		if (elements("txt_warning").size() != 0) {
			Assert.assertTrue("Assertion Failed : Warning message should not appear", false);
		}else{
			Assert.assertTrue(true);
		}
		logMessage("Search Results for Thesaurus are displayed correctly");
	}

}
