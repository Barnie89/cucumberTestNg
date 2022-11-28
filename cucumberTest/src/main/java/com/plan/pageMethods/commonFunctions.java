package com.plan.pageMethods;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.plan.Utils.helper;
import com.plan.pageLocators.loginPage;

public class commonFunctions  {
	
	public static Properties prop = new Properties();	
	
	 //static WebDriver driver= helper.getDriver();
	public static void clickElement(String objName) throws Exception
	{
		getElementWithLocator(objName).click();
	}
	
	public static void getUrl(String objName) throws Exception
	{
		helper.getDriver().get(objName);
	}

	
	public static WebElement getElementWithLocator(String objName) throws Exception {
		WebElement element=null;
		By searchBy=null;
		if(objName.equals(null)||objName.trim().equals("")){
			throw new Exception("Object Description must be provided");
		}else {

		String[] locatorTypeAndValueArray = objName.split("~");
		String locatorType = locatorTypeAndValueArray[0].trim();
		String locatorValue = locatorTypeAndValueArray[1].trim();
		switch (locatorType.toUpperCase()) {
		case "ID":
			searchBy= By.id(locatorValue);
			break;
		case "NAME":
			searchBy= By.name(locatorValue);
			break;
		case "TAGNAME":
			searchBy= By.tagName(locatorValue);
			break;
		case "LINKTEXT":
			searchBy= By.linkText(locatorValue);
			break;
		case "PARTIALLINKTEXT":
			System.out.println("xx");
			searchBy= By.partialLinkText(locatorValue);
			break;
		case "XPATH":
			searchBy= By.xpath(locatorValue);
			break;
		case "CSS":
			searchBy= By.cssSelector(locatorValue);
			break;
		case "CLASSNAME":
			searchBy= By.className(locatorValue);
			break;
		default:
			
		}
		
		element=helper.getDriver().findElement(searchBy);	
		
		return element;	
		}
    }
	
	
	
	
}
