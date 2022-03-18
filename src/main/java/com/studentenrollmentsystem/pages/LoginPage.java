package com.studentenrollmentsystem.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.studentenrollmentsystem.utilities.DriverUtility;

public class LoginPage extends DriverUtility{



	@FindBy(linkText="Register as New Student")
	private WebElement register_as_newstudent;

	@FindBy(xpath="/html/body/app-root/app-header/section[2]/div/div[2]/ul[2]/li/button/a")
	private WebElement loginbutton;
	

	@FindBy(xpath="/html/body/app-root/app-login/div/div[2]/app-studentlogin/body/div/form/div[1]/input")
	private WebElement email;

	@FindBy(name="password")
	private WebElement password;

	//role
	@FindBy(name="role")    		   //dropdown
	private WebElement role;

	//sign-in
	@FindBy(name="sign-in")    		   
	private WebElement signin;
	
	//log out
	@FindBy(xpath="/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[7]/a")

	private WebElement logout;
	
	// Register as Employee
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/a[2]/strong[1]")
	private WebElement register_as_newemployee;

	public LoginPage() {
		//this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void clickRegisterAsNewStudent(){

		this.register_as_newstudent.click();
	}

	public void clickLoginButton() {
		this.loginbutton.click();

	}

	public void setEmail(String email) {

		if(this.email.isEnabled()) {
			this.email.clear();
			this.email.sendKeys(email);
		}
	} 

	public String getEmail() {

		return this.email.getText();
	} 

	public void setPassword(String password) {

		if(this.password.isEnabled()) {
			this.password.clear();
			this.password.sendKeys(password);
		}
	}

	public void setRole(String role) { //Drop Down

		Select selectedRole = new Select(this.role);
		selectedRole.selectByVisibleText(role);

	}

	public void clickSignIn(){

		this.signin.click();

	}
    //Handle Alert
	public String getAlertText() throws InterruptedException {

		//this.signin.click();
		Thread.sleep(1000);
		Alert alert =driver.switchTo().alert();
		String alertText=alert.getText();
		return alertText;

	}

   //For Click on Ok provide in Alert
	public void alertOK() {

		Alert alert =driver.switchTo().alert();
		alert.accept();// For OK
	}
	
	public void clickRegisterAsNewEmployee() {
		
	   this.register_as_newemployee.click();
	   
	}

	public void LogOut(){
		
		this.logout.click();
	}


}
