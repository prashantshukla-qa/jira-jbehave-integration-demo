package com.qait.automation.getpageobjects;

import static com.qait.automation.getpageobjects.ObjectFileReader.getELementFromFile;
import static com.qait.automation.utils.ConfigPropertyReader.getProperty;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qait.automation.utils.LayoutValidation;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

//import static org.testng.Assert.fail;
//import static org.testng.Assert.assertTrue;
//import static org.testng.Assert.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class GetPage extends BaseUi {

    protected WebDriver webdriver;
    String pageName;
    LayoutValidation layouttest;

    public GetPage(WebDriver driver, String pageName) {
        super(driver, pageName);
        this.webdriver = driver;
        this.pageName = pageName;
        layouttest = new LayoutValidation(driver, pageName);
    }

    public void testPageLayout(List<String> tagsToBeTested) {
        layouttest.checklayout(tagsToBeTested);
    }

    public void testPageLayout(String... tagToBeTested) {
        testPageLayout(Arrays.asList(tagToBeTested));
    }

    public void testPageLayout() {
        testPageLayout(Arrays.asList(getProperty("./Config.properties", "browser")));
    }

    // TODO: put this in right place, create dedicated class for frame and window handlers
    protected void switchToNestedFrames(String frameNames) {
        switchToDefaultContent();
        String[] frameIdentifiers = frameNames.split(":");
        for (String frameId : frameIdentifiers) {
            wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator(frameId
                    .trim()));
        }
    }

    protected WebElement element(String elementToken) {
        return element(elementToken, "");
    }

    protected WebElement element(String elementToken, String replacement)
            throws NoSuchElementException {
        WebElement elem = null;
        try {
            elem = wait.waitForElementToBeVisible(webdriver
                    .findElement(getLocator(elementToken, replacement)));
        } catch (NoSuchElementException excp) {
            fail("FAILED: Element " + elementToken + " not found on the " + this.pageName + " !!!");
        }
        catch (NullPointerException npe){
            
        }
        return elem;
    }

    protected WebElement element(String elementToken, String replacement, String replacement1)
            throws NoSuchElementException {
        WebElement elem = null;
        try {
            elem = wait.waitForElementToBeVisible(webdriver
                    .findElement(getLocator(elementToken, replacement, replacement1)));
        } catch (NoSuchElementException excp) {
            fail("FAILED: Element " + elementToken + " not found on the " + this.pageName + " !!!");
        }
        catch (NullPointerException npe){
            
        }
        return elem;
    }

    protected List<WebElement> elements(String elementToken, String replacement) {
        return wait.waitForElementsToBeVisible(webdriver.findElements(getLocator(
                elementToken, replacement)));
    }

    protected List<WebElement> elements(String elementToken) {
        return elements(elementToken, "");
    }

    protected void isStringMatching(String actual, String expected) {
        assertEquals(actual, expected);
        logMessage("ACTUAL STRING : " + actual);
        logMessage("EXPECTED STRING :" + expected);
        logMessage("String compare Assertion passed.");
    }

    protected boolean isElementDisplayed(String elementName,
            String elementTextReplace) {
        wait.waitForElementToBeVisible(element(elementName, elementTextReplace));
        boolean result = element(elementName, elementTextReplace).isDisplayed();
        assertTrue("TEST FAILED: element '" + elementName
                + "with text " + elementTextReplace + "' is not displayed.", result);
        logMessage("TEST PASSED: element " + elementName + " with text "
                + elementTextReplace + " is displayed.");
        return result;
    }

    protected void verifyElementText(String elementName, String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertEquals(  "TEST FAILED: element '" + elementName
                + "' Text is not as expected: ", element(elementName).getText().trim(), expectedText);
        logMessage("TEST PASSED: element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected void verifyElementTextContains(String elementName, String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertThat("TEST FAILED: element '" + elementName + "' Text is not as expected: ",
                element(elementName).getText().trim(), containsString(expectedText));
        logMessage("TEST PASSED: element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected boolean isElementDisplayed(String elementName) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = element(elementName).isDisplayed();
        assertTrue( "TEST FAILED: element '" + elementName
                + "' is not displayed.", result);
        logMessage("TEST PASSED: element " + elementName
                + " is displayed.");
        return result;
    }

    protected boolean isElementEnabled(String elementName, boolean expected) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = expected && element(elementName).isEnabled();
        assertTrue( "TEST FAILED: element '" + elementName
                + "' is  ENABLED :- " + !expected, result);
        logMessage("TEST PASSED: element " + elementName
                + " is enabled :- " + expected);
        return result;
    }

    protected By getLocator(String elementToken) {
        return getLocator(elementToken, "");
    }

    protected By getLocator(String elementToken, String replacement) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
//        System.out.println(locator[2]);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    protected By getLocator(String elementToken, String replacement1, String replacement2) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = StringUtils.replace(locator[2], "$", replacement1);
        locator[2] = StringUtils.replace(locator[2], "%", replacement2);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    private By getBy(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case id:
                return By.id(locatorValue);
            case xpath:
                return By.xpath(locatorValue);
            case css:
                return By.cssSelector(locatorValue);
            case name:
                return By.name(locatorValue);
            case classname:
                return By.className(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }
}
