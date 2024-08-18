package com.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;




public class Example 
{
	public static AndroidDriver driver;	
	
	
	public static void main(String [] args) throws MalformedURLException   
	{	
		startServer();
		openCalculator();
		
	}
	
	
	public static void startServer()
	{
		
		AppiumServiceBuilder builder ;
		try
		{
			  builder = new AppiumServiceBuilder().
		              withAppiumJS(new File("C:\\Users\\Windows\\.appium\\node_modules\\appium-uiautomator2-driver\\lib\\startAppium.js"))    
			          .withIPAddress("127.0.0.1").usingPort(4723);

			
		}
		catch(Exception e)
		{
			System.out.println("Starting the sever"+e.getMessage());
		}
	}
	
	
	public static  void openCalculator() throws MalformedURLException
	{
		
		
		UiAutomator2Options opt = new UiAutomator2Options();
		

		opt.setDeviceName("DEMO1");
		opt.setApp("C:\\Users\\Windows\\OneDrive\\Desktop\\123prog'\\appiumtests\\APK\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),opt);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.quit();		
	}
	
}
	


