package parallelTest;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.plan.Utils.helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	
	//private static helper help;
	private helper hl= new helper();
	private WebDriver driver;
	 @Before(order=0)
	    public  void readFile() throws InvalidPropertiesFormatException, IOException {
	       hl.ReadConfigData();
	       
	    }
	 
	 @Before(order=1)
	    public  void setUpBrowser() throws InvalidPropertiesFormatException, IOException {
        
        driver= hl.setUpDriver();
        
	    }

	 
	    @After(order=0)
	    public  void quitBrowser() {
	 
	        
	        if(driver!=null)
	   		 driver.close();
	   		 driver.quit();	       
	        
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
