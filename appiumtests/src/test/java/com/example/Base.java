package com.example;

import java.io.File;
import java.net.URL;
import java.time.Duration;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base 
{

	public static AndroidDriver driver;	
	public static AppiumDriverLocalService service;

	
	public static void startServer()
	{				
		try
		{
			AppiumServiceBuilder  builder = new AppiumServiceBuilder().
					              withAppiumJS(new File("C:\\Users\\Windows\\.appium\\node_modules\\appium-uiautomator2-driver\\lib\\startAppium.js"))    
						          .withIPAddress("127.0.0.1").usingPort(4723);
			service=AppiumDriverLocalService.buildService(builder);
			service.start();
			System.out.println("Server was Started");
			
		}
		catch(Exception e)
		{
			System.out.println("Starting the sever"+e.getMessage());
		}
	}
	
	public static  void launchTheApp()
	{
		  
		try
		{
			UiAutomator2Options options = new UiAutomator2Options();	
			options.setDeviceName("DEMO1");
			options.setApp("C:\\Users\\Windows\\OneDrive\\Desktop\\123prog'\\appiumtests\\APK\\ApiDemos-debug.apk");
			options.setAppActivity("io.appium.android.apis.ApiDemos");	
			
			//Create object for androidDriver
			driver = 	new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		catch(Exception e)
		{
			System.out.println("launch The App ->"+e.getMessage());
		}
		
	}

    public static void closeTheService()
    {
    	service.close();
    }

    public static void closeTheBroser()
    {
    	driver.quit();
    	
    	System.out.println("App Closed");
    }

    
}
