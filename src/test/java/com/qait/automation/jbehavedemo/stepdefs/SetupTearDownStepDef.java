package com.qait.automation.jbehavedemo.stepdefs;

import static com.qait.automation.utils.YamlReader.getData;

import org.jbehave.core.annotations.BeforeStory;

import com.qait.automation.TestSessionInitiator;

public class SetupTearDownStepDef {

	static TestSessionInitiator test = null;

	@BeforeStory
	public void setup() {
		if (test == null) {
			test = new TestSessionInitiator();
			test.launchApplication(getData("app_url"));
		}
	}	
}
