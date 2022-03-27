/* TestEnrollClass :

Created On :27/02/2022
Purpose: validate the student registration functionality
It includes:
1.validateRegisterAsStudent 
2.validateEnroll 
3.validateInvalidEnroll
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
import com.studentenrollmentsystem.utilities.DriverUtility;
import com.studentenrollmentsystem.utilities.ExcelUtility;

public class TestEnrollClass extends DriverUtility {

	HomePage objHome;
	LoginPage objLogin;
	EnrollPage objEnroll;

	// Login function for Student

	@Test(priority = 23,description=" :Validate Register as New Student button redirection")
	public void validateRegisterAsStudent() throws IOException {

		objHome = new HomePage();
		objLogin = new LoginPage();

		objHome.clickLogin();
		objLogin.clickRegisterAsNewStudent();

		String expectedURL = AutomationConstants.ENROLLEPAGEURL;
		String actualURL = driver.getCurrentUrl();

		// System.out.println(expectedURL);
		Assert.assertEquals(actualURL, expectedURL);
	}

	// Function to validate Enroll a course in Student page

	@Test(priority = 24,description=" :Validate the student registration with valid data from the login page")
	public void validateEnroll() throws IOException {

		objHome = new HomePage();
		objLogin = new LoginPage();

		// objHome.clickLogin();

		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Student", 0); // Passing sheet name and Column number
		// System.out.println(result);

		objLogin.clickLoginButton();

		objLogin.clickRegisterAsNewStudent();

		objEnroll = new EnrollPage();

		objEnroll.setName(result.get(0).toString());

		objEnroll.setEmail(result.get(1).toString());

		objEnroll.setPassword(result.get(2).toString());

		objEnroll.setPhone(result.get(3).toString());

		objEnroll.setAddress(result.get(4).toString());

		objEnroll.setDistrict(result.get(5).toString());

		objEnroll.setState(result.get(6).toString());

		objEnroll.setQualification(result.get(7).toString());

		objEnroll.setPassout(result.get(8).toString());

		objEnroll.setSkills(result.get(9).toString());

		objEnroll.setEmploymentStatus(result.get(10).toString());

		objEnroll.setTechTraining(result.get(11).toString());

		objEnroll.setCourse(result.get(12).toString());
		System.out.println(result.get(12).toString());

		objEnroll.uploadImage(result.get(13).toString());

		objEnroll.clickRegister();

		objEnroll.TestTransaction();

		objEnroll.closeWindow();

		String expectedAlert = AutomationConstants.PAYMENT;
		try {

			String actualAlert = objLogin.getAlertText();

			Assert.assertEquals(actualAlert, expectedAlert);

			objLogin.alertOK();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Function to Check InValidate Enroll in Student page

	@Test(priority = 25, enabled = true,description=" Validate the student registration with invalid data from the login page")
	public void validateInvalidEnroll() throws IOException {

		objHome = new HomePage();
		objLogin = new LoginPage();

		// Get data from Excel

		ArrayList<Object> result = new ArrayList<Object>();
		// result = ExcelUtility.getExcelData("Student",1);//Passing sheet name and
		// Column number
		result = ExcelUtility.getExcelData("StudentInvalid", 0);
		// System.out.println(result);

		// objHome.clickLogin();

		objLogin.clickLoginButton();

		objLogin.clickRegisterAsNewStudent();

		objEnroll = new EnrollPage();

		objEnroll.setName(result.get(0).toString());

		objEnroll.setEmail(result.get(1).toString());

		objEnroll.setPassword(result.get(2).toString());

		objEnroll.setPhone(result.get(3).toString());

		objEnroll.setAddress(result.get(4).toString());

		objEnroll.setDistrict(result.get(5).toString());

		objEnroll.setState(result.get(6).toString());

		objEnroll.setQualification(result.get(7).toString());

		objEnroll.setPassout(result.get(8).toString());

		objEnroll.setSkills(result.get(9).toString());

		objEnroll.setEmploymentStatus(result.get(10).toString());

		objEnroll.setTechTraining(result.get(11).toString());

		objEnroll.setCourse(result.get(12).toString());

		objEnroll.uploadImage(result.get(13).toString());

		String expectedEmailErrorMessage = AutomationConstants.STDEMAILERRORMESSAGE;
		String actualEmailErrorMessage = objEnroll.getEmailErrorMessage();
		Assert.assertEquals(actualEmailErrorMessage, expectedEmailErrorMessage);

		String expectedPasswordErrorMessage1 = AutomationConstants.STDPASSWORDERRORMESSAGE;
		String actualPasswordErrorMessage1 = objEnroll.getPwdErrorMessage();
		Assert.assertEquals(actualPasswordErrorMessage1, expectedPasswordErrorMessage1);

		String expectedPhoneErrorMessage2 = AutomationConstants.STDPHONEERRORMESSAGE;
		String actualPhoneErrorMessage2 = objEnroll.getPhoneErrorMessage();
		Assert.assertEquals(actualPhoneErrorMessage2, expectedPhoneErrorMessage2);

		objEnroll.clickRegister();

		

	}

}
