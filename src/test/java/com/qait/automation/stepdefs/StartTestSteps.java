package com.qait.automation.stepdefs;

import static com.qait.automation.utils.YamlReader.getData;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;

import com.qait.automation.TestSessionInitiator;

public class StartTestSteps {

    TestSessionInitiator test;

    public StartTestSteps(TestSessionInitiator test) {
        this.test = test;
    }

    @BeforeStory
    public void beforeIHaveLaunchedTheApplication() {
        this.test.launchApplication(getData("app_url"));
    }

    @Given("I have launched the application")
    public void givenIHaveLaunchedTheApplication() {
        this.test.launchApplication(getData("app_url"));
    }

    @Given("I close the application")
    public void givenICloseTheApplication() {
        this.test.closeTestSession();
    }

    @AfterStories
    public void quitBrowserSession() {
        this.test.closeTestSession();
    }
}
