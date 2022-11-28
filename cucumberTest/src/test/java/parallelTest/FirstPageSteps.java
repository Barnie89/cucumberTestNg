package parallelTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.plan.Utils.helper;
import com.plan.pageLocators.firstPage;
import com.plan.pageLocators.loginPage;
import com.plan.pageMethods.commonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstPageSteps {
	
	private firstPage first = new firstPage(helper.getDriver());
    @Given("User is on FirstPage")
    public void loginTests() throws Exception {   
    	
    	first.loginTest1();     
        
    }

 
        
    }
    
    
   


