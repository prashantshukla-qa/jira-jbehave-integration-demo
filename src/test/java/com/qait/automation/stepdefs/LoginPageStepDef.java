/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.stepdefs;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.GetPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author Prashant Shukla <prashantshukla@qainfotech.com>
 */
public class LoginPageStepDef extends GetPage {

    TestSessionInitiator test;

    public LoginPageStepDef(TestSessionInitiator test) {
        super(test.getDriver(), "LoginPage");
        this.test = test;
    }

    @Given("I am on Login Page")
    public void givenIAmOnLoginPage() {
        this.test.launchApplication("http://localhost/demo-app/sign_in.html");
    }

    @Then("I am on Login Page")
    public void thenIAmOnLoginPage() {

    }

    @When("I select $user as user")
    public void whenISelectAsUser(String user) {
        selectProvidedTextFromDropDown(element("inp_username"), user);
    }

    @When("Enter $password as password")
    public void whenEnterCorrectPasswordAsPassword(String Password) {
        element("inp_password").sendKeys(Password);
    }

    @When("Click login button")
    public void whenClickLoginButton() {
        element("btn_login").click();
    }

    @Then("The error message $errormsg is displayed")
    public void thenTheErrorMessageIsDisplayed(String errmsg) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginPageStepDef.class.getName()).log(Level.SEVERE, null, ex);
        }
        verifyElementText("txt_error", errmsg);
    }
}
