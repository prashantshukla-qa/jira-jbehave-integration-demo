package com.qait.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

/**
 * 
 * @author prashantshukla
 */
public class LoginPageActionKeyWords extends GetPage {

	public LoginPageActionKeyWords(WebDriver driver) {
		super(driver, "LoginPage");
	}

	public void verifyUserIsOnLoginPage() {
		verifyPageTitleExact("User account | Alexander Street");
	}
	
	public void enterUsernameToLogin(String username) {
		element("inpt_username").sendKeys(username);
	}
	
	public void enterPasswordToLogin(String password){
		element("inpt_password").sendKeys(password);		
	}
	
	public void clickLoginButton(){
		element("btn_login").click();
	}
}
