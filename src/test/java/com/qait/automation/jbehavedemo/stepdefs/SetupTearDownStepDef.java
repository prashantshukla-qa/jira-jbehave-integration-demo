package com.qait.automation.jbehavedemo.stepdefs;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;

import com.qait.automation.TestSessionInitiator;

public class SetupTearDownStepDef {

	TestSessionInitiator test;

	@BeforeStories
	public void setup() {
		if (test == null) {
			test = new TestSessionInitiator();
		}
	}
	
	@AfterStories
	public void tearDown(){
		test = null;
	}
	
}
