package com.accesshq.warsword.util;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.accesshq.warsword.util.Config;

public class DriverFactory
{
	//Have not been able to use the Config values
    public static WebDriver buildDriver() throws MalformedURLException
    {
        WebDriver driver = buildLocalDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS );

        return driver;
    }
    
    private static WebDriver buildLocalDriver() {
    	 
    	switch (Config.BROWSER) {
 		case "chrome":
 			// chromedriver in path, or set ....
            // System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver77/chromedriver.exe");
             ChromeOptions chromeOptions = new ChromeOptions();
             if(Config.HEADLESS) {
         		chromeOptions.addArguments("headless");
         	}
 			return new ChromeDriver(chromeOptions);
 		case "firefox":
 			// geckodriver in path, or set ....
             // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
 			
 			return new FirefoxDriver();		
 		case "edge":
 			return new EdgeDriver();
 		default:
 			throw new IllegalArgumentException(String.format("Invalid local browser parameter - '%s'", Config.BROWSER));
         }
    }


}


