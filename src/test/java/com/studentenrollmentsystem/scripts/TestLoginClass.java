
package com.studentenrollmentsystem.scripts;
	import java.io.IOException;
    import java.util.ArrayList;

	
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.studentenrollmentsystem.constants.AutomationConstants;
	import com.studentenrollmentsystem.pages.HomePage;
	import com.studentenrollmentsystem.pages.LoginPage;

import com.studentenrollmentsystem.utilities.DriverUtility;
import com.studentenrollmentsystem.utilities.ExcelUtility;

	public class TestLoginClass extends DriverUtility {

		HomePage objHome;
		LoginPage objLogin;

		@Test(priority = 0,description ="validate the Login functionality of Admin with Invalid password")
		public void verifyInValidAdminLoginPassword() throws IOException {
			objHome = new HomePage();
			objLogin = new LoginPage();

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data for Admin InValid Login From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",3); //Passing sheet name and Column number
			//System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());
			  
			objLogin.clickSignIn();
		    
			try {
				String expectedAlert = AutomationConstants.LOGINADMINVALIDPASWORD;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		

		@Test(priority = 1, enabled = true ,description ="validate the Login functionality with Invalid User")
		public void validtionofInValidUserLogin() throws IOException {

			objHome = new HomePage();
			objLogin = new LoginPage();

			// Get Data From Excel
			ArrayList<Object> email = new ArrayList<Object>();
			ArrayList<Object> password = new ArrayList<Object>();
			ArrayList<Object> role = new ArrayList<Object>();
			email = ExcelUtility.getExcelData("InvalidUser", 0);
			password = ExcelUtility.getExcelData("InvalidUser", 1);
			role = ExcelUtility.getExcelData("InvalidUser", 2);

			// Passing sheet name and Column number
			// System.out.println(email);
			for (int i = 0; i < email.size(); i++) {

				System.out.println(email.get(i).toString());
				objHome.clickLogin();

				objLogin.clickLoginButton();

				objLogin.setEmail(email.get(i).toString());

				objLogin.setPassword(password.get(i).toString());

				objLogin.setRole(role.get(i).toString());

				objLogin.clickSignIn();

				try {
					String expectedAlert = AutomationConstants.LOGININVALID;
					String actualAlert = objLogin.getAlertText();

					Assert.assertEquals(actualAlert, expectedAlert);
					objLogin.alertOK();

				} catch (InterruptedException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		 
		
		@Test(priority = 2, enabled=false, description="validate the Login functionality of Student with Invalid password")
		public void verifyInValidStudentLoginPassword() throws IOException {
			objHome = new HomePage();
			objLogin = new LoginPage();

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data for Admin InValid Login From Excel
			
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",6); //Passing sheet name and Column number
			//System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());
			  
			objLogin.clickSignIn();
		    
			try {
				String expectedAlert = AutomationConstants.LOGINSTDENTINVALIDPASSWORD;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	   
		
		
		@Test(priority = 3, description ="validate the Login functionality of Employee with Invalid password")
		public void verifyInValidEmployeeLoginPassword() throws IOException {
			objHome = new HomePage();
			objLogin = new LoginPage();

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data for Admin InValid Login From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",5); //Passing sheet name and Column number
		    //System.out.println(result);

			objLogin.setEmail(result.get(0).toString());
			  
			objLogin.setPassword(result.get(1).toString());
			  
			objLogin.setRole(result.get(2).toString());
			  
			objLogin.clickSignIn();
		    
			try {
				String expectedAlert = AutomationConstants.LOGINEMPINVALIDPASSWORD;
				String actualAlert = objLogin.getAlertText();

				Assert.assertEquals(actualAlert, expectedAlert);
				objLogin.alertOK();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		

		@Test(priority = 4, description ="Validate Login function for Employee")
		public void verifyValidEmployeeLogin() throws IOException {
			objHome = new HomePage();
			objLogin = new LoginPage();

			objHome.clickLogin();
			objLogin.clickLoginButton();
			
			//Get Data From Excel
			ArrayList<Object> result = new ArrayList<Object>();
			result = ExcelUtility.getExcelData("Login",2);
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
				objLogin.LogOut();

			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	
	

}



