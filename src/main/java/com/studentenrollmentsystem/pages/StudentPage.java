/*Student Page 
 Created by Elvy Maria Joseph 
 Created on 01/03/2022*/

package com.studentenrollmentsystem.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.studentenrollmentsystem.utilities.DriverUtility;

//ForScroll pages
//import org.openqa.selenium.JavascriptExecutor;

public class StudentPage extends DriverUtility{
	//WebDriver driver;

	// @FindBy(linkText="VIEW PROFILE")
	// private WebElement viewprofile;

	@FindBy(xpath = " //*[@id=\"home\"]/div/div/div/div/div/div/a")
	private WebElement viewprofile;

	// Student ID:
	@FindBy(xpath = "/html/body/app-root/app-myprofile/div/div/div/div/div[1]/div/div[2]/p[1]/strong")
	private WebElement studentId;

	@FindBy(xpath = "/html/body/app-root/app-myprofile/div/div/div/div/div[2]/div[1]/div[2]/div/a/span")
	private WebElement update;

	@FindBy(xpath = "/html/body/app-root/app-update-student/div/form/div/div[12]/button")
	private WebElement updateform;


	@FindBy(name = "name")
	private WebElement name;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "address")
	private WebElement address;

	@FindBy(name = "district")
	private WebElement district;

	@FindBy(name = "state")
	private WebElement state;

	@FindBy(name = "qualification") // dropdown
	private WebElement qualification;

	@FindBy(name = "passout") // drop down
	private WebElement passout;

	@FindBy(name = "skills")
	private WebElement skills;

	@FindBy(name = "employmentStatus") // dropdown
	private WebElement employmentstatus;

	@FindBy(name = "techtraining")
	private WebElement techtraining;

	// public void setStudentId(WebElement studentId) {
	// this.studentId = studentId;
	// }
	public StudentPage() {
		//this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void setName(String name) {

		if (this.name.isEnabled()) {
			this.name.clear();
			this.name.sendKeys(name);
		}
	}

	public void setEmail(String email) {

		if (this.email.isEnabled()) {
			this.email.clear();
			this.email.sendKeys(email);
		}
	}

	public void setPassword(String password) {

		if (this.password.isEnabled()) {
			this.password.clear();
			this.password.sendKeys(password);
		}
	}

	public void setPhone(String phone) {

		if (this.phone.isEnabled()) {
			this.phone.clear();
			this.phone.sendKeys(phone);
		}
	}

	public void setAddress(String address) {

		if (this.address.isEnabled()) {
			this.address.clear();
			this.address.sendKeys(address);
		}
	}

	public void setDistrict(String district) {

		if (this.district.isEnabled()) {
			this.district.clear();
			this.district.sendKeys(district);
		}
	}

	public void setState(String state) {

		if (this.state.isEnabled()) {
			this.state.clear();
			this.state.sendKeys(state);
		}
	}

	public void setQualification(String qualification) { // Drop Down

		if (this.state.isEnabled()) {
			this.state.clear();
			this.state.sendKeys(qualification);
		}

	}

	public void setPassout(String passout) {

		if (this.passout.isEnabled()) {
			this.passout.clear();

			this.passout.sendKeys(passout);
		}
	}

	public void setSkills(String skills) {

		if (this.skills.isEnabled()) {
			this.skills.clear();
			this.skills.sendKeys(skills);
		}
	}

	public void setEmploymentStatus(String employmentstatus) { // Drop down

		Select selectedEmploymentStatus = new Select(this.employmentstatus);
		selectedEmploymentStatus.selectByVisibleText(employmentstatus);

	}

	public void setTechTraining(String techtraining) {

		if (this.techtraining.isEnabled()) {
			this.techtraining.clear();
			this.techtraining.sendKeys(techtraining);
		}
	}

	// http://64.227.182.128/home

	public void clickViewProfile() {
		if (this.viewprofile.isEnabled())
			this.viewprofile.click();
	}

	
	public String getStudentId() {
		// if(this.getStudentId().isE)
		String emailid = this.studentId.getText();
		return emailid;

	}

	public void clickOnUpdate() {

		if (this.update.isDisplayed()) {
			this.update.click();
		}

	}

	public void clickOnFormUpdate() throws InterruptedException{

		if (this.updateform.isDisplayed()) {
			this.updateform.click();
			Thread.sleep(2000);
		}

	}

}
