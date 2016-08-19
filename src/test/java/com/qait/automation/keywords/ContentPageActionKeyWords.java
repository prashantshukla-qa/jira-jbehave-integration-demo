package com.qait.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class ContentPageActionKeyWords extends GetPage {

	WebDriver driver;

    public ContentPageActionKeyWords(WebDriver driver) {
        super(driver, "ContentPage");
        this.driver = driver;
    }

	public void verifyDetailedRecordIsVisible() {
		wait.hardWait(5);
		isElementDisplayed("mainContentArea");
	}

	public void clickOnResultListLink() {
		element("link_resultList").click();
		logMessage("Clicked on Result List link");
		wait.hardWait(5);
	}
	
}
