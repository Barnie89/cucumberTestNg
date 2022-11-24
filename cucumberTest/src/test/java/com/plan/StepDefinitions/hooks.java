package com.plan.StepDefinitions;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.plan.Utils.helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	
	 @Before
	    public static void setUp() throws InvalidPropertiesFormatException, IOException {
	       helper.ReadConfigData();
	       helper.setUpDriver();
	    }
	 
	    @After
	    public static void tearDown(Scenario scenario) {
	 
	        //validate if scenario has failed
	        if(scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) helper.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName()); 
	        }   
	         
	        helper.tearDown();
	    }

}
