/*TestStudentProfileUpdateClass 
Created On :01/03/2022
Purpose: validate the Registered student profile update functionality
It includes:
1.validteStudentLogin 
2.validateUpdateStudentProfile 
*/

package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.EnrollPage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.pages.StudentPage;
import com.studentenrollmentsystem.utilities.DriverUtility;
import com.studentenrollmentsystem.utilities.ExcelUtility;
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestStudentProfileUpdateClass extends DriverUtility {

	HomePage objHome;
	LoginPage objLogin;
	StudentPage objStudent;
	EnrollPage objEnroll;

	// Login function for Student

	@Test(priority = 26 ,description = "Validate the login Functionality of Student")
	public void validteStudentLogin() throws IOException {

		objHome = new HomePage();
		objLogin = new LoginPage();

		objHome.clickLogin();
		objLogin.clickLoginButton();

		// Get Data From Excel
		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Login", 1); // Passing sheet name and Column number

		objLogin.setEmail(result.get(0).toString());

		objLogin.setPassword(result.get(1).toString());

		objLogin.setRole(result.get(2).toString());

		objLogin.clickSignIn();

		try {
			String expectedAlert = AutomationConstants.LOGINSUCCESS;
			String actualAlert = objLogin.getAlertText();

			Assert.assertEquals(actualAlert, expectedAlert);
			objLogin.alertOK();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 27 , description ="Validate the Update profile functionality of the registered student")

	// Function to validate Update StudentProfile from student page

	 public void validateUpdateViewProfile() throws IOException, InterruptedException {
	
		objStudent = new StudentPage();
		

        PageUtility.scrollPageUp(driver);

		objStudent.clickViewProfile();
		String expectedURL = AutomationConstants.STDPROFILEURL;
		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(actualURL, expectedURL);

		String actualText = objStudent.getStudentId();
		System.out.println(actualText);

		objStudent.clickOnUpdate();

		String expectedURL1 = AutomationConstants.UPDATESTUDENTURL;

		String actualURL1 = driver.getCurrentUrl();
		Assert.assertEquals(actualURL1, expectedURL1);

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("StudentProfileUpdate", 0);

		objEnroll = new EnrollPage();
		// objStudent.setName("John");
		// objStudent.setPhone("1234567890");

		objStudent.setAddress(result.get(0).toString());
		objStudent.clickOnFormUpdate();
		//Thread.sleep(1000);
		String expectedURL2 = AutomationConstants.HOMEPAGEURL;

		String actualURL2 = driver.getCurrentUrl();
		Assert.assertEquals(actualURL2, expectedURL2);

		objLogin.LogOut();

		String expectedURL3 = AutomationConstants.LOGINPAGEURL;
		String actualURL3 = driver.getCurrentUrl();
		// System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(actualURL3, expectedURL3);

	}

}
