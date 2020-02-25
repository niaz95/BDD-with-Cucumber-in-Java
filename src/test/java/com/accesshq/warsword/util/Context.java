package com.accesshq.warsword.util;

import org.openqa.selenium.WebDriver;

public class Context {
		
	protected static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driverInstance.get();
	}
	
	public static void setDriver(WebDriver driver) {
		driverInstance.set(driver);
	}
	
	public static void quitDriver() {
		driverInstance.get().quit();
		driverInstance.remove();
	}

}
