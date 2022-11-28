package com.plan.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class helper {
	
	public WebDriver driver;
	public static Properties prop = new Properties();
	
//	 public static WebDriver getDriver() {
//         return driver;              
//     }
//	 
	
	 
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); 
	 
	public WebDriver setUpDriver(){
		 String browser = prop.getProperty("BROWSER");
		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
						tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		
			return  tlDriver.get();	
		
		
		
	}

	
	
	public void ReadConfigData() throws InvalidPropertiesFormatException, IOException {
		File file=new File((System.getProperty("user.dir").toString().replace("\\", "\\\\")+"\\src\\test\\resources\\Environment\\"+"configuration.xml"));
		FileInputStream fileInput=new FileInputStream(file);
		prop.loadFromXML(fileInput);
		fileInput.close();	
		
	}
	
}
