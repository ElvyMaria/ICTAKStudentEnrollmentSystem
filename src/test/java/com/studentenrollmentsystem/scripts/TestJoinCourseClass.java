/*TestJoinCourseClass

Created On :02/03/2022

Purpose: validate the student registration functionality 
It includes:
1.ValidateJoinCourse : Validate Student Registration using the using the Go Through Courses button  provide in the Homepage of Student Enrollment System  
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
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestJoinCourseClass extends DriverUtility{
	
	 HomePage objHome; 
	 EnrollPage objEnroll;
	 PageUtility objPage;
	 LoginPage objLogin;
	 

	 
	 @Test(priority =28, description ="Function to validate joining  a course through home page")
	 public void ValidateJoinCourse() throws InterruptedException, IOException  {
		 
		 objHome = new HomePage(); 
		 //objPage = new PageUtility(); 
		 objLogin = new LoginPage();
		 
		 
		 objHome.clickGoThroughCourse();
		 
		// String expectedURL="http://64.227.182.128/courses";
		 String expectedURL=AutomationConstants.COURSESPAGEURL;
		 String actualURL=driver.getCurrentUrl();
		 Assert.assertEquals(actualURL, expectedURL);
		 
		 PageUtility.scrollPageDown(driver);
		 objHome.mousehover();
		 
		// String expectedURL1="http://64.227.182.128/course";
		 String expectedURL1=AutomationConstants.COURSEPAGEURL;
		 String actualURL1=driver.getCurrentUrl();
		 Assert.assertEquals(actualURL1, expectedURL1);
		 
		 objHome.clickOnEnrollNow();
		 
		 //String expectedURL2="http://64.227.182.128/enroll";
		 String expectedURL2=AutomationConstants.ENROLLEPAGEURL;
		 String actualURL2=driver.getCurrentUrl();
		 Assert.assertEquals(actualURL2, expectedURL2);
		 
		objLogin = new LoginPage();
	   // objHome.clickLogin();
			 
			 
		ArrayList<Object> result = new ArrayList<Object>();
		result = ExcelUtility.getExcelData("Student",0); //Passing sheet name and Column number
		//System.out.println(result);
			
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
}