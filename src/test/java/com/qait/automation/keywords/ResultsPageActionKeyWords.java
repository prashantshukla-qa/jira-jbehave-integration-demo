package com.qait.automation.keywords;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class ResultsPageActionKeyWords extends GetPage {

	WebDriver driver;

	public ResultsPageActionKeyWords(WebDriver driver) {
		super(driver, "ResultsPage");
		this.driver = driver;
	}

	public void verifySearchResults(String resultText) {
		wait.hardWait(5);
		System.out.println(getPageTitle().trim());
		System.out.println("Result List: " + resultText + ": EBSCOho");
		if (getPageTitle().trim().equalsIgnoreCase("Result List: " + resultText + ": EBSCOhost")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
/*
		Assert.assertEquals(getPageTitle().trim(), "Result List: " + resultText + ": EBSCOhost",
				"Assertion Failed : Results Page title is not correct");*/
		isElementDisplayed("area_searchResult");
		logMessage("Search Results successfully displayed");
		wait.hardWait(2);
	}

	public void selectFirstResult() {
		element("link_firstResult").click();
		logMessage("Clicked on First Result Link");
	}

	public void clickOnCreateAlertButton() {
		element("btn_createAlert").click();
		logMessage("Clicked on Create Alert Button");
	}

	public void filterBySourceType() {
		element("chkbox_academicJournal").click();
		logMessage("Selected Academic Journal Filter");
	}

	public void verifyResults() {
		wait.hardWait(5);
		String count = element("txt_countAcademicJournal").getText();
		Assert.assertTrue("Assertion Failed : Result Count is correct after applying filter",
				element("header_search").getText().contains(count.substring(1, count.length() - 1)));
	}

}
