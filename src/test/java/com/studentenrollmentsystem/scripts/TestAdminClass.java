
/* TestAdminAddCourseClass

Purpose:Validate the Admin Add Course Functionality
*/

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

public class TestAdminClass extends DriverUtility {

	LoginPage objLogin ; 
	HomePage objHome ;
	AdminPage objAdmin ;
	PageUtility objPage ;
	AdminHome objAdHome;

	
	@Test(priority = 14 ,description ="validate Login function for Admin")
	public void verifyValidAdminLogin() throws IOException {
		
		objLogin =new LoginPage(); 
		objHome = new HomePage();
		
		objHome.clickLogin();
//		objLogin.clickLoginButton();

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


	
	@Test(priority = 15,description ="validate reset a course in admin page")
	public void validateResetCourse() throws IOException, InterruptedException {

		objLogin = new LoginPage();
		objHome = new HomePage();
		
		objAdmin = new AdminPage();

		//verifyValidAdminLogin();

		objAdmin.clickCourses();

		objAdmin.clickAddCourse();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getRowData("AddCourse");
        objAdmin.setNameOfCourse(result.get(0).toString());

		objAdmin.clickResetAddcourse();
		
		Thread.sleep(1000);
		String expectedURL = AutomationConstants.ADMINADDCOURSEURL;
		String actualURL =driver.getCurrentUrl();

		Assert.assertEquals(actualURL, expectedURL);

		
	}
	
	

	@Test(priority = 16 , description ="validate add a course in admin page")
	public void validateAddCourse() throws IOException, InterruptedException {

		objLogin = new LoginPage();
		objHome = new HomePage();
		objAdmin = new AdminPage();
		

		//verifyValidAdminLogin();

		objAdmin.clickCourses();

		objAdmin.clickAddCourse();


		PageUtility.scrollPageUp(driver);

		

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getRowData("AddCourse");



		objAdmin.setNameOfCourse(result.get(0).toString());

		objAdmin.setNameOfCourse(result.get(0).toString());

		objAdmin.setCertification(result.get(1).toString());

		objAdmin.setCode(result.get(2).toString());

		objAdmin.setDetails(result.get(3).toString());

		objAdmin.setPrice(result.get(4).toString());

		objAdmin.setEligibility(result.get(5).toString());

		objAdmin.UploadImage(result.get(6).toString());

        objAdmin.clickAddNewCourse();
		
        Thread.sleep(1000);
        String expectedURL = AutomationConstants.ADMINCOURSES;
		String actualURL =driver.getCurrentUrl();

		Assert.assertEquals(actualURL, expectedURL);


	}
	
	@Test(priority =17, description ="validate  edit a course in admin page")
	public void verifyEditCourse() throws IOException, InterruptedException {

		objLogin = new LoginPage();
		objHome = new HomePage();
		objAdmin = new AdminPage();
		

		objAdmin.clickCourses();

		PageUtility.scrollPageDown(driver);

		objAdmin.MousehoverEdit();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getRowData("AddCourse");

		objAdmin.setEligibility("Any Degree");

		objAdmin.UploadImage(result.get(6).toString());

		objAdmin.clickUpdateCourse();
		Thread.sleep(1000);
		String expectedURL = AutomationConstants.ADMINCOURSES;
	    String actualURL =driver.getCurrentUrl();
        
	 
		Assert.assertEquals(actualURL, expectedURL);
		
	}

	

	
	@Test(priority =18, enabled = false ,description ="validate Know more about a course in admin pag")
	public void verifyKnowMore() throws IOException, InterruptedException {

		objLogin = new LoginPage();
		objHome = new HomePage();
		objAdmin = new AdminPage();
		

		objAdmin.clickCourses();

		PageUtility.scrollPageDown(driver);

		objAdmin.MousehoverKnowMore();
	
		
		String expectedURL = AutomationConstants.COURSEPAGEURL;
	    String actualURL =driver.getCurrentUrl();

		Assert.assertEquals(actualURL, expectedURL);

		objLogin.LogOut();
		
		String expectedURL1 = AutomationConstants.LOGINPAGEURL;
	    String actualURL1 =driver.getCurrentUrl();

		Assert.assertEquals(actualURL1, expectedURL1);

		

	}


	

}
