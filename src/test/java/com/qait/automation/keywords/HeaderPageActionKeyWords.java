package com.qait.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class HeaderPageActionKeyWords extends GetPage {

	WebDriver driver;

    public HeaderPageActionKeyWords(WebDriver driver) {
        super(driver, "HeaderPage");
        this.driver = driver;
    }

	public void clickOnThesaurusLink() {
		element("link_thesaurus").click();
		logMessage("Clicked on Thesaurus link");
	}
	
}
