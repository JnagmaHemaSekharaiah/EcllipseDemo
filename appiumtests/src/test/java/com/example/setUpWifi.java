package com.example;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class setUpWifi extends Base
{	
	
	public static void setUpWifiOfApk() 
	{
		try
		{
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		Thread.sleep(2000);	
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/checkbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\r\n"));              
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	public static void main(String[] args)  
	{
		
		Base.startServer();
		Base.launchTheApp();
		setUpWifi.setUpWifiOfApk();
		Base.closeTheService();
		Base.closeTheBroser();	
	}
	
}
