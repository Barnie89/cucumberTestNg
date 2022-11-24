package com.plan.StepDefinitions;

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

public class LoginPage {
	
    @Given("User is on Loginpage")
    public void loginTest() {   
    	
      helper.openPage(loginPage.URL);
      
        
    }
    
    @Then("Click on About")
    public void clickAbout() throws Exception {  
    	
      commonFunctions.clickElement(loginPage.about);
      Thread.sleep(5000);
        
    }
    
    
    @Then("Close driver")
    public void closeDriver() {       
      helper.tearDown();
        
    }


}
