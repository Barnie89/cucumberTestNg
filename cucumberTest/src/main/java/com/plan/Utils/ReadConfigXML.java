package com.plan.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class ReadConfigXML {
	
	private static Properties prop;
	
	public Properties ReadConfigData() throws InvalidPropertiesFormatException, IOException {
		prop= new Properties();
		File file=new File((System.getProperty("user.dir").toString().replace("\\", "\\\\")+"\\src\\test\\resources\\Environment\\"+"configuration.xml"));
		FileInputStream fileInput=new FileInputStream(file);
		prop.loadFromXML(fileInput);
		fileInput.close();	
		return prop;
		
	}
	

}
