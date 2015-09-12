package com.qait.automation.stepdefs;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.GetPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class HomePageStepDef extends GetPage {

    public HomePageStepDef(TestSessionInitiator test) {
        super(test.getDriver(), "HomePage");
    }

    @Given("I am on Home Page")
    public void givenIAmOnHomePage() {

    }

    @When("I click Sign In link")
    public void whenIClickSignInLink() {
        element("lnk_signin").click();
    }

    @Then("I am taken to Login Page")
    public void thenIAmTakenToLoginPage() {
    }

    @When("I click register link")
    @Given("I click register link")
    public void whenIClickRegisterLink() {
        element("lnk_register").click();
    }

    @Then("I am taken to Welcome Page")
    public void thenIAmTakenToWelcomePage() {
    }
}
