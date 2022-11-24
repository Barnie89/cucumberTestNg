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

import io.github.bonigarcia.wdm.WebDriverManager;

public class helper {
	
	public static WebDriver driver=null;
	public  SessionId session=null;
	public static Properties prop = new Properties();
	
	 public static WebDriver getDriver() {
         return driver;              
     }
	 
	 public static void openPage(String url) {
         driver.get(url);
     }
	 
	public static void setUpDriver(){
        String browser = prop.getProperty("BROWSER");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
            	   //session = ((ChromeDriver)driver).getSessionId();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
            	System.setProperty("webdriver.gecko.driver","./src/test/lib/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                 //session = ((FirefoxDriver)driver).getSessionId();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
	
	
	public static void ReadConfigData() throws InvalidPropertiesFormatException, IOException {
		File file=new File((System.getProperty("user.dir").toString().replace("\\", "\\\\")+"\\src\\test\\resources\\Environment\\"+"configuration.xml"));
		FileInputStream fileInput=new FileInputStream(file);
		prop.loadFromXML(fileInput);
		fileInput.close();	
		
	}
	  public static void tearDown() {
          
          if(driver!=null) {
               driver.close();
               driver.quit();
          }
	  }

}
