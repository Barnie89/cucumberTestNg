package parallelTest;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.plan.Utils.ReadConfigXML;
import com.plan.Utils.helper;

import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

	// private static helper help;
	private helper hl = new helper();
	private WebDriver driver;
	private WindowsDriver driver1;
	public static Properties prop;
	private ReadConfigXML readconfig;

	@Before(order = 0)
	public void readFile() throws InvalidPropertiesFormatException, IOException {
		readconfig = new ReadConfigXML();
		prop = readconfig.ReadConfigData();

	}

	@Before(order = 1)
	public void setUpBrowser() throws InvalidPropertiesFormatException, IOException, InterruptedException {

		if (prop.getProperty("TESTING").equalsIgnoreCase("singlebrowser")) {
			String browser = prop.getProperty("BROWSER");
			driver = hl.setUpDriver(browser);
		} else if (prop.getProperty("TESTING").equalsIgnoreCase("desktop")) {
			driver1 = helper.desktopApp();
		} else if (prop.getProperty("TESTING").equalsIgnoreCase("remote")) {
			String browser= crossBrowserRunner.BROWSER.get();
			Runtime.getRuntime().exec("cmd /c start start_dockerGrid.bat");
			Thread.sleep(15000);
			//String browser = prop.getProperty("BROWSER");
			driver = hl.setupRemoteDriver(browser);
		} else if (prop.getProperty("TESTING").equalsIgnoreCase("crossbrowser")) {
//			String browser= crossBrowserRunner.BROWSER.get();
//			driver = hl.setUpDriver(browser);
		}

	}

	@After(order = 0)
	public void quitBrowser() throws IOException, InterruptedException {
		if (prop.getProperty("TESTING").equalsIgnoreCase("singlebrowser")) {

			if (driver != null)
				driver.close();
			// driver.quit();
		} else if (prop.getProperty("TESTING").equalsIgnoreCase("desktop")) {
			if (driver1 != null)
				driver1.close();
			// driver1.quit();
			helper.stop();
		} else if (prop.getProperty("TESTING").equalsIgnoreCase("remote")) {
			Runtime.getRuntime().exec("cmd /c start stop_dockerGrid.bat");
			Thread.sleep(5000);
			if (driver != null)
				driver.close();
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

		}

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
