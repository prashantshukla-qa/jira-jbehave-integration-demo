/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.stepdefs;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.GetPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class RegistrationPageStepDef extends GetPage {
    
    TestSessionInitiator test;

    public RegistrationPageStepDef(TestSessionInitiator test) {
        super(test.getDriver(), "RegistrationPage");
        this.test = test;
    }

    @Then("I am on Registration Page")
    public void thenIAmOnRegistrationPage() {
        verifyPageTitleExact();
    }

    @When("I am on Registration Page")
    public void whenIAmOnRegistrationPage() {
        this.test.launchApplication("localhost/demo-app/register.html");
    }

}
