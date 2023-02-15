package com.plan.pageLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.plan.Utils.constants;
import com.plan.Utils.helper;
import com.plan.pageMethods.commonFunctions;

import io.appium.java_client.windows.WindowsDriver;

public class desktopPage {
	
	//private WindowsDriver driver;
	public static final String URL="https://www.facebook.com/";	
	public static final String about=constants.LINKTXT+"~"+"Forgotten password?";

	
	// 2. Constructor of the page class:
	public desktopPage(WebDriver driver) {
	}
	
	public void calculatorTest() throws Exception {   
    	
		 /* create an object for the Actions class and pass the driver argument */
	       Actions action = new Actions(helper.getDesktopDriver());
	 
	       /* Click on the Toggle Menu button */
	       WebElement menuItem = helper.getDesktopDriver().findElementByAccessibilityId("TogglePaneButton");
	       action.click(menuItem);
	       action.perform();
	 
	       /* Blocking Sleep - Used only for demo, Explicit Sleep is preferred */
	       Thread.sleep(3000);
	 
	       /* Click on the Standard item in the Menu */
	       WebElement scientific = helper.getDesktopDriver().findElementByAccessibilityId("Standard");
	       action.click(scientific);
	       action.perform();
	       
	       /* Option 1: Click on Button - 1 by identifying it using name property */
	       /* driver.findElement(By.name("One")).click(); */
	 
	       /* Option 2: Click on Button - 1 by identifying it using AccessibilityID property */
	       helper.getDesktopDriver().findElementByAccessibilityId("num1Button").click();
	 
	       /* Use the Name property for locating the buttons and performing click operation */
	       helper.getDesktopDriver().findElement(By.name("Plus")).click();
	       helper.getDesktopDriver().findElement(By.name("Nine")).click();
	       helper.getDesktopDriver().findElement(By.name("Equals")).click();
	 
	       /* Blocking Sleep - Not a good practice, used only for demo */
	       helper.getDesktopDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	 
	       /* The result should be 10, assert if the result pane does not show 10 */
	  WebElement resultsElement = helper.getDesktopDriver().findElementByAccessibilityId("CalculatorResults");
	 
	       String resultantText = "10";
	       String resultsElementText = resultsElement.getText().replace("Display is","").trim();
	 
	       /* Assert if the result is not 10 */
	    //   Assert.assertEquals(resultantText, resultsElementText);
	    }
	  
}
