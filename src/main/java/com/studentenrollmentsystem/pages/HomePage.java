package com.studentenrollmentsystem.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.studentenrollmentsystem.utilities.DriverUtility;

public class HomePage extends DriverUtility{
	
	//WebDriver driver;
	
	//@FindBy(xpath="/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[1]/a")
	//private WebElement home;
	

	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement home;
	//
	
	@FindBy(xpath="//a[contains(text(),'Go through our courses')]")
	private WebElement gothroughcourse;
	
//	@FindBy(xpath="//*[@id=\"team\"]/div[2]/a/button") // Cannot locate an element using xpath
//	private WebElement showmore;
	
	@FindBy(xpath="/html/body/app-root/app-home/section[3]/div[2]/a[1]/button[1]")
	private WebElement showmore;
	
	@FindBy(xpath="/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[2]/a")
	private WebElement course;
	
	@FindBy(xpath="/html/body/app-root/app-header/section[2]/div/div[2]/ul[2]/li/button/a")
	private WebElement login;
	
	//@FindBy(xpath="//*[@id=\"team\"]/div[1]/div/div[2]/div/div[1]/div/div/button/a") // Cannot locate an element using xpath
	//private WebElement knowmore;
	
	 @FindBy(xpath="//*[@id=\"courses\"]/div/div/div[2]/div[1]/div/div/button") // Cannot locate an element using xpath
	 private WebElement knowmore;
	
	
	@FindBy(xpath ="/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[2]/a")
	private WebElement coursestab;
	
	@FindBy(xpath="//*[contains(text(),'Enroll Now')]")
	private WebElement enrollnow;
	
	//@FindBy(xpath="//*[contains(text(),'Wallet')]")
	//private WebElement wallet;
	
	
	
	public HomePage() {
		
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void clickHome(){
		if(this.home.isEnabled())
		 this.home.click();
	}
	
	public void clickGoThroughCourse() {
		if(this.gothroughcourse.isEnabled())
		gothroughcourse.click();
	}
	
	public void clickShowMore() {
		
	  if(this.showmore.isEnabled())
		this.showmore.click();
	}
	
	public void clickCourse() {
		if(this.course.isEnabled())
			this.course.click();
	}
	
	public void clickLogin() {
		if(this.login.isEnabled())
			this.login.click();
	}
		
	
	public void clickKnowMore() {
		if(this.knowmore.isEnabled())
			this.knowmore.click();
	}
	
	public void mousehover() {
		//Instantiate Action Class        
	    Actions actions = new Actions(driver);
	    //Retrieve WebElemnt 'slider' to perform mouse hover 
		//WebElement slider = driver.findElement);
		//Move mouse to x offset 50 i.e. in horizontal direction
		actions.moveToElement(knowmore,50,0).perform();
		knowmore.click();
		//System.out.println("Moved slider in horizontal directions");
		}
		
		public void clickOnEnrollNow() {
			if(this.enrollnow.isDisplayed())
				this.enrollnow.click();
			
		}
	
	 
	 
}
