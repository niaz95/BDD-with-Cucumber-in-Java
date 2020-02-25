package com.accesshq.warsword.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.accesshq.warsword.util.DriverFactory;




@Execution(ExecutionMode.CONCURRENT)
class BaseTest {
	
	protected WebDriver driver;


	protected static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();
	
	protected WebDriver getDriver() throws MalformedURLException {
		return driverInstance.get();
	}
	
	@Before
	public void setUp() throws MalformedURLException {	
		WebDriver driver = DriverFactory.buildDriver();
		driver.get("https://www.warsword.com.au/");	
		driverInstance.set(driver);
	}
	
	@After
	public void afterEach(ExtensionContext context) throws Exception {
			
			Optional<Throwable> executionException = context.getExecutionException();
			if(executionException.isPresent()) {
				WebDriver driver = getDriver();
				String timeAndDate = new SimpleDateFormat("yyyy-dd-MM-HH-mm-s").format(new Date());
				if (driver instanceof TakesScreenshot) {
					TakesScreenshot screenshotTakingDriver = (TakesScreenshot) driver;
					File screenshotDirectory = new File(new File("target"), "screenshots");
					if (!screenshotDirectory.exists() || !screenshotDirectory.isDirectory()) {
						screenshotDirectory.mkdirs();
					}
					File screenshotFile = new File(screenshotDirectory, context.getDisplayName().replaceAll("[()]", "") + timeAndDate + ".png");
					try {
						Files.move(screenshotTakingDriver.getScreenshotAs(OutputType.FILE).toPath(), screenshotFile.toPath());
						context.publishReportEntry("Screenshot saved to "  + screenshotFile.toPath());
					} catch (WebDriverException | IOException e) {
						e.printStackTrace();
					}
					// TODO: detect alert, close it and take second screenshot
				}
			}
			getDriver().quit();
	}



}
