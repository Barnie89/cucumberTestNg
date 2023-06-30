package com.plan.Utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class helper {

	public WebDriver driver;
	public static Properties prop = new Properties();

//	 public static WebDriver getDriver() {
//         return driver;              
//     }
//	 

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static ThreadLocal<WindowsDriver> tlwinDriver = new ThreadLocal<>();
	public static WindowsDriver wdriver;
	public static DesiredCapabilities capability = new DesiredCapabilities();
    public static String remote_url = "http://localhost:4444/wd/hub";
    public static ChromeOptions chromeopt= new ChromeOptions();
    public static EdgeOptions edgeopt = new EdgeOptions();
	public static String appPath = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";

	public WebDriver setUpDriver(String browser) {
		//String browser = prop.getProperty("BROWSER");
		System.out.println("browser value is: " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			chromeopt.addArguments("--remote-allow-origins*");
			tlDriver.set(new ChromeDriver(chromeopt));
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().driverVersion("0.30.0").setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		}
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	
	public WebDriver setupRemoteDriver(String browser) throws MalformedURLException {
		
		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			DesiredCapabilities dc = DesiredCapabilities.chrome();			
			capability.setCapability("version","");
     		tlDriver.set(new RemoteWebDriver(new URL(remote_url),dc));
		} else if (browser.equals("firefox")) {
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			capability.setCapability("version","");
			tlDriver.set(new RemoteWebDriver(new URL(remote_url),dc));
		}
		else if (browser.equals("edge")) {
			DesiredCapabilities dc = DesiredCapabilities.edge();
			capability.setCapability("version","");
			tlDriver.set(new RemoteWebDriver(new URL(remote_url),dc));
		}else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static WindowsDriver<?> desktopApp() throws MalformedURLException {

		capability.setCapability("ms:experimental-webdriver", true);
		capability.setCapability("app", appPath);
		capability.setCapability("platformName", "Windows");
		capability.setCapability("deviceName", "Windows10Machine");

		/* Start WinAppDriver.exe so that it can start listening to incoming requests */
		WinappDriver.start();
		tlwinDriver.set(new WindowsDriver(new URL("http://127.0.0.1:4723/"), capability));
		//wdriver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capability);
		return getDesktopDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {

		return tlDriver.get();

	}

	public static synchronized WindowsDriver<?> getDesktopDriver() {

		//return wdriver;
		return tlwinDriver.get();

	}

	public static void stop() {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("taskkill ", "/f", "/IM", "WinAppDriver.exe");
			processBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
