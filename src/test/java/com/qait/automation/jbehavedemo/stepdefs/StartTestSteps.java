package com.qait.automation.jbehavedemo.stepdefs;

import static com.qait.automation.utils.YamlReader.getData;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StartTestSteps extends SetupTearDownStepDef {

	@BeforeScenario
	public void beforeIHaveLaunchedTheApplication() {
		test.launchApplication(getData("app_url"));
	}

	@Given("I am on home page")
	public void givenIamOnHomePage() {
		test.homepage.verifyUserIsOnHomePage();
	}

	@When("I click on Sign In link")
	public void whenIClickOnSignInLink() {
		test.homepage.clickSignInLink();
	}

	@Then("I am navigated to home page")
	public void thenIamNavigatedToHomePage() {
		test.homepage.verifyUserIsOnHomePage();
	}

	@When("I click on $link link to show menu")
	public void whenIClickOnLinkToShowMenu(){
	test.homepage.clickOnLinkToShowMenu();	
	}
	
	@When("I type $searchText in Search field to perform Basic Search")
	public void whenITypeInSearchField(@Named("searchText") String searchText){
		test.homepage.typeSearchTextToSearchResults(searchText);
	}
	
	@When("I click Search button")
	public void whenIClickSearchButton(){
		test.homepage.clickSearchButton();
	}

	/*
	 * @Given("I close the application") public void givenICloseTheApplication()
	 * { this.test.closeTestSession(); }
	 */

	@AfterStories
	public void quitBrowserSession() {
		test.closeTestSession();
	}
}
