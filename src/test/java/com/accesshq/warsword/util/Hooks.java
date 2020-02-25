package com.accesshq.warsword.util;

import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	//Does not run. Using hooks in StepDefinitions.class instead
	@Before
	public void beforeScenario() throws MalformedURLException {	
		Context.setDriver(DriverFactory.buildDriver());
		
	}
	
	@After
	public void afterScenario() throws MalformedURLException {
		Context.quitDriver();
	}

}
