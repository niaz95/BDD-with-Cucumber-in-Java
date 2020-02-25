package com.accesshq.warsword.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static final String BROWSER;
	public static final String APP_URL;
	public static final Long IMPLICIT_WAIT_SECONDS;
	public static final boolean HEADLESS;
	
	static {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try(InputStream resourceStream = loader.getResourceAsStream("app.properties")) {
		    props.load(resourceStream);
		} catch (IOException e) {
			System.err.println("Unable to load config.properties");
			e.printStackTrace();
		} 
		
		BROWSER = props.getProperty("browser");
		IMPLICIT_WAIT_SECONDS = Long.parseLong(props.getProperty("implicit-wait-seconds"));
		APP_URL = props.getProperty("app-url");
		HEADLESS = Boolean.parseBoolean(props.getProperty("headless"));
		
	}

}
