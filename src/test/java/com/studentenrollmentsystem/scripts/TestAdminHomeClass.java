package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.AdminHome;
import com.studentenrollmentsystem.pages.AdminPage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.utilities.DriverUtility;
import com.studentenrollmentsystem.utilities.ExcelUtility;
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestAdminHomeClass extends DriverUtility{
	
	LoginPage objLogin;
	HomePage objHome;
	AdminPage objAdmin;
	
	AdminHome objAdhome;

	
	//Login function for Admin 
	
	@Test(priority = 6)
	public void verifyValidAdminLogin() throws IOException {
		objHome = new HomePage();
		objLogin = new LoginPage();

		objHome.clickLogin();
		objLogin.clickLoginButton();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Login",0); //Passing sheet name and Column number
		//System.out.println(result);

		objLogin.setEmail(result.get(0).toString());
		  
		objLogin.setPassword(result.get(1).toString());
		  
		objLogin.setRole(result.get(2).toString());
		objLogin.clickSignIn();


		try {
			String expectedAlert = AutomationConstants.LOGINSUCCESS;
			String actualAlert = objLogin.getAlertText();

			Assert.assertEquals(actualAlert, expectedAlert);
			objLogin.alertOK();

		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Function to see the Employee details in admin page
	
	@Test(priority = 7)
	public void empList() throws InterruptedException {
	objLogin = new LoginPage();
	objAdhome =new AdminHome();
	
	objAdhome.employeeList();
	String expected =AutomationConstants.ADMINEMPLOYEESURL;
	//System.out.println(driver.getCurrentUrl());
	String actual =driver.getCurrentUrl();
	Assert.assertEquals(expected,actual);
	
	}
	
	
	// Function to Approve Employee in admin page
		@Test(priority = 8)
		public void employeeApprove() throws InterruptedException, IOException {
			
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Admin",0);
					
			objAdhome =new AdminHome();
			objHome = new HomePage();
			objAdhome.employeeList();
			PageUtility.scrollPageDown(driver);;
			objAdhome.employee_app();
			PageUtility.scrollPageDown(driver);
			objAdhome.approveEmployee(result.get(0).toString());
			
			try {
				String expectedAlert = AutomationConstants.ADMINAPPROVE;
				String actualAlert = objLogin.getAlertText();
	            System.out.println("actualAlert "+ actualAlert);
				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		// Function to Reject Employee in admin page
	@Test(priority = 9)
	public void employeeReject() throws InterruptedException, IOException {
		
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Admin",1);
		objAdhome =new AdminHome();
		objHome = new HomePage();
		objAdhome.employeeList();
		PageUtility.scrollPageDown(driver);;
		objAdhome.employee_app();
		PageUtility.scrollPageDown(driver);
		
		objAdhome.rejectEmployee(result.get(0).toString());
		//getAlertText()
		try {
			String expectedAlert = AutomationConstants.ADMINREJECT;
			String actualAlert = objLogin.getAlertText();
            System.out.println(actualAlert);
			Assert.assertEquals(actualAlert, expectedAlert);
			objLogin.alertOK();

		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	   
	// Function to Edit Employee details in admin page
	@Test(priority = 10)
	public void employeeEdit() throws InterruptedException, IOException {
		
		
		objAdhome =new AdminHome();
		objHome = new HomePage();
		objAdhome.clickOnEmployeetab();
		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Admin",0);
		String expectedURL= AutomationConstants.ADMINEMPLOYEESURL;
		
		String actualURL= driver.getCurrentUrl();
		//System.out.println(actualURL);
		Assert.assertEquals(actualURL, expectedURL);
		objAdhome.employeeEdit(result.get(0).toString());
		PageUtility.scrollPageDown(driver);
		String expectedURL1 =AutomationConstants.ADMINEDITEMPLOYEEURL;
		String actualURL1=driver.getCurrentUrl();
		//System.out.println(actualURL1);
		Assert.assertEquals(actualURL1,expectedURL1);
		
		ArrayList<Object> result1 = new ArrayList<Object>();
		result1 = ExcelUtility.getExcelData("Admin",3);
		objAdhome.editEmployee(result1.get(0).toString());

		Thread.sleep(1000);
		String expectedURl2=AutomationConstants.ADMINEMPLOYEESURL;
		String actualURL2=driver.getCurrentUrl();
		System.out.println(actualURL2);
		Assert.assertEquals(actualURL2,expectedURl2);
		
		}
	// Function to Approve Employee in admin page
			@Test(priority=11, enabled = false)
			public void employeeDelete() throws InterruptedException, IOException {
				
				ArrayList<Object> result = new ArrayList<Object>();
				result = ExcelUtility.getExcelData("Admin",0);
						
				objAdhome =new AdminHome();
				objHome = new HomePage();
				//objAdhome.employeeList();
				objAdhome.clickOnEmployeetab();
				//PageUtility.scrollPageDown(driver);;
				objAdhome.employee_app();
				//PageUtility.scrollPageDown(driver);
				objAdhome.employeeDelete(result.get(0).toString());
				
				try {
					String expectedAlert = AutomationConstants.ADMINDELETEEMPLOYEE;
					//System.out.println(expectedAlert);
					Thread.sleep(1000);
					String actualAlert = objLogin.getAlertText();
		           // System.out.println(actualAlert);
					Assert.assertEquals(actualAlert, expectedAlert);
					objLogin.alertOK();

				} catch (InterruptedException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
       
	@Test(priority = 12)
	public void validateAdminLogOut() {
		objAdhome= new AdminHome();
		objAdhome.logOut();
		String expectedURl=AutomationConstants.LOGINPAGEURL;
		String actualURL=driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL,expectedURl);
		
	}

}
