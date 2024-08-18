package com.example;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;


public class Gestures extends Base 
{
   
	
	public static void gestures() throws InterruptedException
	{
	WebElement view=	driver.findElement(AppiumBy.accessibilityId("Views"));
	view.click();	
	
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		startServer();
		launchTheApp();
		gestures();
		closeTheService();
		closeTheBroser();

	}

}
