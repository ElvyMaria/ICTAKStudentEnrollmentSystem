/*Enroll Page 

  Created on 27/02/2022  
  */
package com.studentenrollmentsystem.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select; //For Select tag

import com.studentenrollmentsystem.utilities.DriverUtility;

public class EnrollPage extends DriverUtility{

	//WebDriver driver;

	@FindBy(name="name")
	private WebElement name;

	@FindBy(name="email")
	private WebElement email;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(name="phone")
	private WebElement phone;

	@FindBy(name="address")
	private WebElement address;

	@FindBy(name="district")
	private WebElement district;

	@FindBy(name="state")
	private WebElement state;

	@FindBy(name="qualification")       //dropdown
	private WebElement qualification;

	@FindBy(name="passout")			//drop down
	private WebElement passout;

	@FindBy(name="skills")
	private WebElement skills;

	@FindBy(name="employmentStatus")	//dropdown
	private WebElement employmentstatus;

	@FindBy(name="techtraining")
	private WebElement techtraining;

	@FindBy(name="course")    		   //dropdown
	private WebElement course;

	@FindBy(name="coursefee")//disabled
	private WebElement coursefee;

	@FindBy(name="image")
	private WebElement image;

	@FindBy(xpath="/html/body/app-root/app-registerform/div/form/div/div[19]/button")
	private WebElement register;
	
	@FindBy(xpath="/html/body/app-root/app-registerform/div/form/div/div[3]/span")
	private WebElement emailerrormessage;


	@FindBy(xpath="/html/body/app-root/app-registerform/div/form/div/div[7]/span")
	private WebElement phoneerrormessage ;

	@FindBy(xpath="/html/body/app-root/app-registerform/div/form/div/div[5]/span")
	private WebElement pwderrormessage;

	@FindBy(xpath="/html/body/app-root/app-registerform/div/form/div/div[6]/input")
	private WebElement telephoneerrormessage ;

	//studentlogin
	//Frame elements
	//@FindBy(xpath="//*[contains(text(),'Wallet')]")
	//private WebElement wallet;

	@FindBy(xpath="//*[@id=\"form-common\"]/div[1]/div/div/div[3]/div[2]/div/button[4]")
	private WebElement wallet;

	@FindBy(xpath="//*[@id=\"form-wallet\"]/div/button[3]/div/div[2]/div/label/div")
	private WebElement airtelmoney;

	@FindBy(xpath="//*[@id=\"footer\"]")
	private WebElement pay;

	//New Window element
	@FindBy(xpath="/html/body/form/button[1]")
	private WebElement yes;

	public EnrollPage() {
		//this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void setName(String name) {

		if(this.name.isEnabled()) {
			this.name.clear();
			this.name.sendKeys(name);
		}
	}

	public void setEmail(String email) {

		if(this.email.isEnabled()) {
			this.email.clear();
			this.email.sendKeys(email);
		}
	}

	public void setPassword(String password) {

		if(this.password.isEnabled()) {
			this.password.clear();
			this.password.sendKeys(password);
		}
	}

	public void setPhone(String phone) {

		if(this.phone.isEnabled()) {
			this.phone.clear();
			this.phone.sendKeys(phone);
		}
	}

	public void setAddress(String address) {

		if(this.address.isEnabled()) {
			this.address.clear();
			this.address.sendKeys(address);
		}
	}

	public void setDistrict(String district) {

		if(this.district.isEnabled()) {
			this.district.clear();
			this.district.sendKeys(district);
		}
	}

	public void setState(String state) {

		if(this.state.isEnabled()) {
			this.state.clear();
			this.state.sendKeys(state);
		}
	}

	
	public String getPhoneErrorMessage() {
		
		return this.phoneerrormessage.getText();
	}
	
	public void setQualification(String qualification) { //Drop Down

		Select selectedQualification = new Select(this.qualification);
		selectedQualification.selectByVisibleText(qualification);

	}

	public void setPassout(String passout) { 

		if(this.passout.isEnabled()) {
			this.passout.clear();

			this.passout.sendKeys(passout);
		}
	}

	public void setSkills(String skills) { 

		if(this.skills.isEnabled()) {
			this.skills.clear();
			this.skills.sendKeys(skills);
		}
	}

	public void setEmploymentStatus(String employmentstatus) { //Drop down

		Select selectedEmploymentStatus = new Select(this.employmentstatus);
		selectedEmploymentStatus.selectByVisibleText(employmentstatus);

	}

	public void setTechTraining(String techtraining) { 

		if(this.techtraining.isEnabled()) {
			this.techtraining.clear();
			this.techtraining.sendKeys(techtraining);
		}
	}

	public void setCourse(String course) { 

		Select selectedCourse = new Select(this.course);
		selectedCourse.selectByVisibleText(course);
	}

	public void uploadImage(String image) {
		this.image.sendKeys(image);
	}

	public void clickRegister() {
		this.register.click();
	}

	public String getEmailErrorMessage() {
		return this.emailerrormessage.getText();
	}
	public String getPwdErrorMessage() {
		return this.pwderrormessage.getText();
	}
	public String getTelephoneErrorMessage() {
		return this.telephoneerrormessage.getText();
	}



	//Handle Frame 
	public void TestTransaction() {
		driver.switchTo().frame(0);
		try {
			Thread.sleep(2000);

			this.wallet.click();
			Thread.sleep(1000);
			this.airtelmoney.click();
			Thread.sleep(1000);
			this.pay.click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Handle new window
	public void closeWindow() {

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		// Perform the actions on new window
		this.yes.click();
		// Close the new window, if that window no more required
		// driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		// Continue with original browser (first window)
	}
} 

