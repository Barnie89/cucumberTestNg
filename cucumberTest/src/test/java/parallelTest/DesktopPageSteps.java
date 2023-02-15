package parallelTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.plan.Utils.helper;
import com.plan.pageLocators.desktopPage;
import com.plan.pageLocators.loginPage;
import com.plan.pageMethods.commonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DesktopPageSteps {
	
	private desktopPage desktop = new desktopPage(helper.getDriver());
    @Given("User is on Calculatorapp")
    public void calculatorApp() throws Exception {   
    	
      desktop.calculatorTest();    
      Thread.sleep(4000);
        
    }
    
 
    
   

}
