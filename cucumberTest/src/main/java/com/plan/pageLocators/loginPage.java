package com.plan.pageLocators;

import org.openqa.selenium.WebDriver;
import com.plan.Utils.constants;
import com.plan.pageMethods.commonFunctions;

public class loginPage {
	
	private WebDriver driver;
	public static final String URL="https://www.facebook.com/";	
	public static final String about=constants.LINKTXT+"~"+"Forgotten password?";

	
	// 2. Constructor of the page class:
	public loginPage(WebDriver driver) {
	}
	
	public void loginTest() throws Exception {   
    	
		commonFunctions.getUrl(URL);
	        
	    }
	public void clickAbout() throws Exception {
	 commonFunctions.clickElement(about);
	}
	    
}
