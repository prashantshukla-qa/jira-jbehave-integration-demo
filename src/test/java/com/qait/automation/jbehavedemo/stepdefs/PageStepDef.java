package com.qait.automation.jbehavedemo.stepdefs;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class PageStepDef extends SetupTearDownStepDef{
	
    /*@Given("I login to the application as {a|an} $user")
    public void givenILoginToTheApplicationAsAnUser(String user) {
        System.out.println("USER IS " + user + ":- "
                + getData("credentials." + user + ".username"));
        test.loginpage.loginToTheApplicationUsingCredentials(
                getData("credentials." + user + ".username"),
                getData("credentials." + user + ".password"));
    }

    @Given("I am on {the|} Login page")
    public void givenIAmOnTheLoginPage() {
    	test.loginpage.verifyUserIsOnLoginPage();
    }

    @Given("I am on {the|} $pagename page")
    public void givenIAmOnHomePage(String pagename) {
    	test.loginpage.verifyUserIsOnLoginPage();
    }*/
	
	@Then("I am navigated to login page")
	public void thenIamNavigatedToLoginPage(){
		test.loginpage.verifyUserIsOnLoginPage();
	}
	
	@When("I enter username $user")
	public void whenIEnterUsername(@Named("user") String user){
		test.loginpage.enterUsernameToLogin(user);
	}
	
	@When("I enter password $pass")
	public void whenIEnterPassword(@Named("pass") String pass){
		test.loginpage.enterPasswordToLogin(pass);
	}
	
	@When("I click Log In button")
	public void whenIClickLoginButton(){
		test.loginpage.clickLoginButton();
	}
}
