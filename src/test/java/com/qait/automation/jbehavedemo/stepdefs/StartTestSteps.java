package com.qait.automation.jbehavedemo.stepdefs;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StartTestSteps extends SetupTearDownStepDef {

	@BeforeScenario
	public void beforeIHaveLaunchedTheApplication() {
	}

	@Given("I am on home page")
	public void givenIamOnHomePage(){
		test.homepage.verifyUserIsOnHomePage();
	}
	
	@Then("I can see page title as $title")
	public void thenICanSeePageTitle(@Named("title") String title){
		test.homepage.verifyPageTitle(title);
	}

	@Then("I can see $link in the $category section")
	public void thenICanSeeLinkInTheCategorySection(@Named("link") String link, @Named("category") String category){
		test.homepage.verifyLinksInMenu(link, category);
	}
	
	@When("I click on $button button")
	public void whenIClickOnRequestATrailButton(@Named("button")String button){
		test.homepage.clickOnRequestATrialButton(button);
	}
	
	@When("I type $label as $value")
	public void whenITypeLabelAsValue(@Named("label")String label, @Named("value")String value){
		test.homepage.fillValueIntoFormToRequestATrial(label, value);
	}
	
	@When("I select $label as $value")
	public void whenISelectLabelAsValue(@Named("label")String label, @Named("value")String value){
		test.homepage.selectValueInFormToRequestATrial(label, value);
	}
	
	@When("I click close button to close dialog")
	public void whenIClickCloseButtonToCloseDialog(){
		test.homepage.closeDialogWindow();
	}
	
	@When("I click Search icon")
	public void whenIClickSearchIcon(){
		test.homepage.clickSearchIcon();
	}
	
	@When("I type $text into Enter your Keywords field")
	public void whenITypeTextIntoEnterYourKeywordsFiled(@Named("text")String text){
		test.homepage.typeSearchTextIntoSearchField(text);
	}
	
	@When("I select $option radio button to specify search criteria")
	public void whenISelectOptionRadioButtonToSpecifySearchCriteria(@Named("option")String option){
		test.homepage.selectRadioButtonToSpecifySearchType(option);
	}
	
	@When("I click Search button to perform search")
	public void whenIClickSearchButtonToPerformSearch(){
		test.homepage.performSearch();
	}
	
	@Then("I am navigated to Search Results page")
	public void thenIAmNavigatedToSearchResultsPage(){
		test.searchpage.verifyUserIsOnSearchResultsPage();
	}
	
	@Then("I can see $resultCount search results")
	public void thenIcanSeeResultCountSearchResults(@Named("resultCount")String resultCount){
		test.searchpage.verfiySearchResults(resultCount);
	}
	
//	@AfterScenario
//	public void quitBrowserSession() {
//		test.closeTestSession();
//	}
}
