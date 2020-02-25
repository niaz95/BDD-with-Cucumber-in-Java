package com.accesshq.warsword.tests;

import java.net.MalformedURLException;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.accesshq.warsword.pages.HomePage;
import com.accesshq.warsword.util.Config;
import com.accesshq.warsword.util.Context;
import com.accesshq.warsword.util.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseTest {
	
	HomePage homePage;
	protected WebDriver driver;
	
//////////// Cannot access Hooks.class /////////
	@Before
	public void beforeScenario() throws MalformedURLException {	
		Context.setDriver(DriverFactory.buildDriver());
		
	}
	
	@After
	public void afterScenario() throws MalformedURLException {
		Context.quitDriver();
	}
////////////////////////////////////////////////
	
	@Given("We are at the Home Page")
	public void we_are_at_the_Home_Page() throws MalformedURLException {
		driver = Context.getDriver();
		//driver.get("https://www.warsword.com.au/");
		driver.get(Config.APP_URL);
		homePage = new HomePage(driver);
	}
	
	@When("The {string} link is clicked")
	public void the_link_is_clicked(String string) {
		homePage.clickProductSidebarLink(string);
		 System.out.format("Thread ID - %2d - %s .\n",
			        Thread.currentThread().getId(), string);
	}
	
	@Then("The page title is displayed as {string}")
	public void the_page_title_is_displayed_as(String string) throws MalformedURLException {
		Assertions.assertEquals(string, homePage.getPageTitle());
	}
	

	@When("The subscribe modal is closed")
	public void the_subscribe_modal_is_closed() {
	   homePage.closeSubscribeModal();
	}
			
}

