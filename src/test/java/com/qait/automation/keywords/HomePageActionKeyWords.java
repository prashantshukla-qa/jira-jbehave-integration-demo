package com.qait.automation.keywords;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

/**
 *
 * @author prashantshukla
 */
public class HomePageActionKeyWords extends GetPage {

    public HomePageActionKeyWords(WebDriver driver) {
        super(driver, "HomePage");
    }

    public void verifyUserIsOnHomePage() {
        verifyPageTitleContains();
        logMessage("verifying if the user is on the home page");
    }

    public void verifyLinksInMenu(String link, String category) {
        String changedLink = link;
        String verifyingLink = link;
        if (link.equals("Library")) {
            verifyingLink = "libraries";
        }
        if (link.equals("About Us")) {
            changedLink = "about-us";
        }
        String text = element("lnk_menubar", category, changedLink.toLowerCase()).getText();
        logMessage("verifying if the link text for " + verifyingLink + " is correct on the home page");
        Assert.assertEquals(verifyingLink + " link text visible to the user is incorrect", text, verifyingLink.toUpperCase());
    }

    public void verifyPageTitle(String title) {
        verifyPageTitleExact(title);
        logMessage("verifying if the page title \"" + title + "\" is correct on the home page");
    }

    public void clickOnRequestATrialButton(String button) {
        element("lnk_navbar", button).click();
        logMessage("Clicked " + button + " to launch form");
    }

    public void fillValueIntoFormToRequestATrial(String label, String value) {
        switchToDefaultContent();
        wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator("iframe_requestTrial"));
        element("inpt_requestTrial", label).sendKeys(value);
        logMessage("Typed " + label + " as " + value + " in request a trial form");
        switchToDefaultContent();
    }

    public void selectValueInFormToRequestATrial(String label, String value) {
        switchToDefaultContent();
        wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator("iframe_requestTrial"));
        selectProvidedTextFromDropDown(element("drpdwn_requestTrial", label), value);
        logMessage("Selected " + label + " as " + value + " in request a trial form");
        switchToDefaultContent();
    }

    public void closeDialogWindow() {
        element("btn_closeDialog").click();
        logMessage("Clicked close button to close dialog");
        wait.hardWait(3);
    }

    public void clickSearchIcon() {
        element("icn_search").click();
        logMessage("Clicked on Search icon to perform a search");
    }

    public void typeSearchTextIntoSearchField(String value) {
        element("inpt_search").sendKeys(value);
        logMessage("Typed " + value + " to perform a search");
    }

    public void selectRadioButtonToSpecifySearchType(String value) {
        element("inpt_radioSearchType", value).click();
        logMessage("Selected " + value + " to fetch specific type of search results");
    }

    public void performSearch() {
        element("btn_search").click();
        logMessage("Clicked Search button to perform a search on entered query text");
    }
}
