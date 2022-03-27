package com.studentenrollmentsystem.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studentenrollmentsystem.utilities.DriverUtility;

public class EmployeePage extends DriverUtility{

	/* All WebElements are identified by @FindBy annotation */

	//WebDriver driver;

	@FindBy(name = "name")
	private WebElement name;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "role")
	private WebElement role;

	@FindBy(xpath = "/html/body/app-root/app-login/div/div[2]/app-empregister/div/div/form/div/div[7]/button")
	private WebElement register;

	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[3]/a")
	private WebElement allstudents;

	@FindBy(id = "listSearch")
	private WebElement search;

	@FindBy(xpath = "/html/body/app-root/app-students/div/ul[1]/li/div/div[2]/button[1]")
	private WebElement markentrybtn;

	
	@FindBy(xpath = "/html/body/app-root/app-students/div/ul[45]/li/div/div[2]/button[2]")
	private WebElement showStudentDetails;

	@FindBy(name = "techtraining")
	private WebElement markentry;

	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[6]/a")
	private WebElement SearchAll;

	@FindBy(xpath = "//*[@id=\"listSearch\"]")
	private WebElement Searchtextbox;

	@FindBy(xpath = "/html/body/app-root/app-mark-entry/div/form/div/div[5]/button")
	private WebElement update;
	
	//Error msg
	///html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[2]/app-empregister[1]/div[1]/div[1]/form[1]/div[1]/div[3]/span[1]
    //
	
	@FindBy(xpath = "//span[contains(text(),'Email is not valid')]")
	private WebElement emailmsg;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Password should have one Uppercase, one Lowecase a')]")
	private WebElement pwdmsg;
	
	public void clickAllStudents() {
		this.allstudents.click();
	}

	public void clickSearchAll() {
		this.SearchAll.click();
	}

	public void clickShowStudentDetails() {
		this.showStudentDetails.click();
	}

	public void setSearchData() {

		if (this.Searchtextbox.isEnabled()) {
			this.Searchtextbox.clear();
			this.Searchtextbox.sendKeys("John");
		}
	}

	public void setMark(String string) {

		if (this.markentry.isEnabled()) {
			this.markentry.clear();
			this.markentry.sendKeys(string);
		}
	}

	public void clickMarkEntryButton() throws InterruptedException {
		this.markentrybtn.click();
		Thread.sleep(2000);
	}

	public void clickSearch(String search) {
		this.search.sendKeys(search);
	}

	public void clickUpdate() {
		this.update.click();
	}

	public EmployeePage( ) {
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

	public WebElement getName() {
		return name;
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

	public void setRole(String role) {

		if (this.role.isEnabled()) {
			this.role.clear();
			;
			this.role.sendKeys(role);
		}
	}

	public void clickRegister() {

		this.register.click();

	}
	
	public String getEmailmsg() {
		String emsg=this.emailmsg.getText();
		return emsg;
	}
	
	public String getPasswordmsg() {
		String pdsg=this.pwdmsg.getText();
		return pdsg;
	}

}