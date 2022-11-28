package parallelTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.plan.Utils.helper;
import com.plan.pageLocators.loginPage;
import com.plan.pageMethods.commonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageSteps {
	
	private loginPage login = new loginPage(helper.getDriver());
    @Given("User is on Loginpage")
    public void loginTest() throws Exception {   
    	
      login.loginTest();    
      Thread.sleep(4000);
        
    }
    
    @Then("Click on About")
    public void clickAbout() throws Exception {  
    	
     login.clickAbout();
     Thread.sleep(3000);
 
        
    }
    
    
   

}
