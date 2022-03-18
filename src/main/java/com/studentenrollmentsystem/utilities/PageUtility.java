package com.studentenrollmentsystem.utilities;

import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageUtility {

	WebDriver driver;

	
	public PageUtility(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	 public static void scrollPageUp(WebDriver driver) throws InterruptedException {
		 ((JavascriptExecutor)driver).executeScript("scroll(0,-400)");
		 Thread.sleep(1000); 
		 }
	 
	 
	 public static void scrollPageDown(WebDriver driver) throws InterruptedException {
		 ((JavascriptExecutor)driver).executeScript("scroll(0, 400)");
		 Thread.sleep(1000); 
		 }
	
	
}
