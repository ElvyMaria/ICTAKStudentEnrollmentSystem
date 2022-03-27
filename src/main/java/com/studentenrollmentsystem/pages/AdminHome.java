
package com.studentenrollmentsystem.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studentenrollmentsystem.utilities.DriverUtility;

public class AdminHome extends DriverUtility{
	//WebDriver driver;

	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[7]/a")
	private WebElement logOut;

	@FindBy(linkText = "ALL STUDENTS")
	private WebElement students;

	@FindBy(linkText = "EMPLOYEES")
	private WebElement emp;

	@FindBy(linkText = "EMPLOYEE APPROVAL")
	private WebElement emp_app;

	@FindBy(xpath = "/html/body/app-root/app-employeeapproval/div/ul[1]/li/div[2]/button[1]")
	private WebElement approv_bt;

	@FindBy(xpath = "/html/body/app-root/app-employees/div/ul[1]/li/div[2]/button[1]")
	private WebElement edit_bt;

	@FindBy(xpath = "/html/body/app-root/app-employees/div/ul[1]/li/div[2]/button[2]")
	private WebElement delete_bt;

	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[1]/input")
	private WebElement edit_name;
	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[3]/input")
	private WebElement edit_role;
	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[2]/input")
	private WebElement edit_email;
	@FindBy(xpath = "/html/body/app-root/app-update-employee/div/div/form/div/div[4]/button")
	private WebElement update_bt;

	@FindBy(linkText = "SEARCH")
	private WebElement search;

	@FindBy(id = "listSearch")
	private WebElement listSearch;

	@FindBy(xpath = "/html/body/app-root/app-students/div/ul/li/div/div[2]/button[1]")
	private WebElement delete;

	@FindBy(xpath = "/html/body/app-root/app-employeeapproval/div/ul[1]/li/div[2]/button[2]")
	private WebElement reject_bt;

	@FindBy(xpath = "/html/body/app-root/app-students/div/ul[1]/li/div/div[2]/button[2]")
	private WebElement showDetails;

	@FindBy(id = "//button[@class='btn btn-primary']")
	private WebElement details;

	@FindBy(xpath = "//a[contains(text(),'Employees')]")
	private WebElement employeetab;

	public AdminHome() {
		
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void logOut() {
		logOut.click();
	}

	public String deleteStudent() throws InterruptedException {

		students.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		delete.click();
		Alert alert = driver.switchTo().alert();
		String alertText2 = alert.getText();
		// System.out.println(alertText2);
		alert.accept();
		return alertText2;
	}

	public void showStdDetails() throws InterruptedException {

		students.click();

		/*
		 * if(this.listSearch.isEnabled()) { this.listSearch.clear();
		 * //this.listSearch.sendKeys(AutomationConstants.STD_NAME);
		 * 
		 * Thread.sleep(1000); } showDetails.click();
		 */

	}

	public void employeeList() throws InterruptedException {

		emp.click();

	}

	// public String employee_app() throws InterruptedException {
	public void employee_app() {

		emp_app.click();

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,1000)"); Thread.sleep(1000);
		 * approv_bt.click(); Thread.sleep(1000); Alert alert=driver.switchTo().alert();
		 * String alertText3=alert.getText(); alert.accept(); return alertText3;
		 */

	}

	public String employee_rej() throws InterruptedException {

		emp_app.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		reject_bt.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertText4 = alert.getText();
		alert.accept();
		return alertText4;

	}

	public void search() throws InterruptedException {

		search.click();
		if (this.listSearch.isEnabled()) {
			this.listSearch.clear();
			this.listSearch.sendKeys("John");
			Thread.sleep(1000);
		}

	}

	public String deleteEmployee() throws InterruptedException {

		emp.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		delete_bt.click();
		Alert alert = driver.switchTo().alert();
		String alertText2 = alert.getText();
		System.out.println(alertText2);
		alert.accept();
		return alertText2;
	}

	

	public void editEmployee(String role) {

	    if (this.edit_role.isEnabled()) {
			this.edit_role.clear();
			this.edit_role.sendKeys(role);
			update_bt.click();
		}
        
	}

	public void approveEmployee(String empName) {

		
		int n = driver.findElements(By.xpath("//body/app-root[1]/app-employeeapproval[1]/div[1]/ul")).size();
		for (int i = 1; i < n; i++) {
			WebElement employeelist = driver.findElement(
					By.xpath("//body/app-root[1]/app-employeeapproval[1]/div[1]/ul[" + i + "]/li[1]/div[1]/h3[1]"));

			String empname = employeelist.getText();

			String expectedname = empName;

			if (empname.equalsIgnoreCase(expectedname)) {
				WebElement approvalbtn = driver.findElement(By.xpath(
						"//body/app-root[1]/app-employeeapproval[1]/div[1]/ul[" + i + "]/li[1]/div[2]/button[1]"));
				//System.out.println(empname);
				//String appemp = approvalbtn.getText();
				//System.out.println(appemp);
				approvalbtn.click();
				break;
			}

		}

	}

	public void rejectEmployee(String empName){

	
		int n = driver.findElements(By.xpath("//body/app-root[1]/app-employeeapproval[1]/div[1]/ul")).size();
		for (int i = 1; i < n; i++) {
			WebElement employeelist = driver.findElement(
					By.xpath("//body/app-root[1]/app-employeeapproval[1]/div[1]/ul[" + i + "]/li[1]/div[1]/h3[1]"));

			String empname = employeelist.getText();

			String expectedname =empName;
			if (empname.equalsIgnoreCase(expectedname)) {
				WebElement rejectbtn = driver.findElement(By.xpath(
						"//body/app-root[1]/app-employeeapproval[1]/div[1]/ul[" + i + "]/li[1]/div[2]/button[2]"));
				System.out.println(empname);
				String rejectemp = rejectbtn.getText();
				System.out.println(rejectemp);
				rejectbtn.click();
				break;
			}

		}

	}

	public void employeeEdit(String empName) {

		int n = driver.findElements(By.xpath("//body/app-root[1]/app-employees[1]/div[1]/ul")).size();
		for (int i = 1; i < n; i++) {
			WebElement employeelist = driver.findElement(
					By.xpath("//body/app-root[1]/app-employees[1]/div[1]/ul[" + i + "]/li[1]/div[1]/h3[1]"));

			String empname = employeelist.getText();

			String expectedname = empName;
			if (empname.equalsIgnoreCase(expectedname)) {
				WebElement editbtn = driver.findElement(
						By.xpath("//body/app-root[1]/app-employees[1]/div[1]/ul[" + i + "]/li[1]/div[2]/button[1]"));
				String editemp = editbtn.getText();
				System.out.println(editemp);
				editbtn.click();
				break;
			}

		}

	}

	public void clickOnEmployeetab() {
		this.employeetab.click();
		

	}
	
	public void employeeDelete(String empName) {

		int n = driver.findElements(By.xpath("//body/app-root[1]/app-employees[1]/div[1]/ul")).size();
		for (int i = 1; i < n; i++) {
			WebElement employeelist = driver.findElement(
					By.xpath("//body/app-root[1]/app-employees[1]/div[1]/ul[" + i + "]/li[1]/div[1]/h3[1]"));

			String empname = employeelist.getText();

			String expectedname = empName;
			if (empname.equalsIgnoreCase(expectedname)) {
				WebElement deletebtn = driver.findElement(
						By.xpath("//body/app-root[1]/app-employees[1]/div[1]/ul[" + i + "]/li[1]/div[2]/button[2]"));

				String deletemp = deletebtn.getText();
				//System.out.println(deletemp);

				deletebtn.click();
				break;
			}

		}

	}

	
	
	
}
