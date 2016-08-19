package com.qait.automation.jbehavedemo.stepdefs;

import com.qait.automation.TestSessionInitiator;
import static com.qait.automation.jbehavedemo.stepdefs.SetupTearDownStepDef.test;
import static com.qait.automation.utils.YamlReader.getData;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StartTestStepDef {

    static TestSessionInitiator test = null;    

    @BeforeScenario
    public void beforeIHaveLaunchedTheApplication() {
        test = new TestSessionInitiator();
        test.launchApplication(getData("app_url"));

    }

    @Given("I am on homepage")
    public void givenIamOnHomePage() {
        test.homepage.verifyUserIsAtHomePage();
    }

    @When("I search for book $text")
    public void whenICanSearchForAuthor(@Named("text") String text) {
        test.homepage.performSearch(text);
    }

    @Then("I can see search results for book $text")
    public void thenICanSeeResultsForBook(@Named("text") String text) {
        test.resultspage.verifySearchResults(text);
    }

    @When("I select first result from search results to view detailed record")
    public void whenISelectFirstResultFromSearch() {
        test.resultspage.selectFirstResult();
    }

    @Then("I can see detailed records for selected result")
    public void thenICanSeeDetailedRecordsForSelectedResult() {
        test.contentpage.verifyDetailedRecordIsVisible();
    }

   /* @When("I navigate back to List of Results")
    public void whenINavigateBackToListOfResults() {
        test.contentpage.clickOnResultListLink();
    }*/

    @When("I filter search results by Source Type")
    public void whenIFilterSearchResultsBySourceType() {
        test.resultspage.filterBySourceType();
    }

    @Then("I can see correct no of search items found")
    public void ThenICanSeeCorrectNoOfSearchItemsFound() {
        test.resultspage.verifyResults();
    }

    @When("I navigate to $text page")
    public void whenINavigatToPage(@Named("text") String text) {
        test.headerpage.clickOnThesaurusLink();
    }

    @When("I perform search for $text in Thesaurus")
    public void whenIPerformSearchForTextInThesaurus(@Named("text") String text) {
        test.thesauruspage.searchTerm(text);
    }
    
    @Then("I can see search results under Thesaurus")
    public void thenICantSeeMessageInTheSearchResultsPage() {
        test.thesauruspage.verifySearchResult();
    }

    @AfterScenario
    public void quitBrowserSession() {
        test.closeTestSession();
    }
}
