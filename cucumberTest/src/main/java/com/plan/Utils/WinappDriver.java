package com.plan.Utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class WinappDriver {
	
	
	  public static void start()
	   {
	       try
	       {
	           Desktop desktop = Desktop.getDesktop();
	 
	           File file = new File("C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe");
	 
	           /* Check if there is support for Desktop or not */
	           if(!Desktop.isDesktopSupported())
	           {
	               System.out.println("not supported");
	               return;
	           }
	 
	           else if (file.exists())
	           {
	               System.out.println("Open WinAppDriver.exe\n");
	               desktop.open(file);
	           }
	       }
	       catch (IOException e)
	       {
	           e.printStackTrace();
	           System.out.println("Encountered Exception\n");
	           throw new RuntimeException(e);
	       }
	   }
	 
	  
	

}
