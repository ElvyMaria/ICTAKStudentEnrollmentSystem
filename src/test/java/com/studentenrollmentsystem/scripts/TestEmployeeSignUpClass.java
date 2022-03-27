package com.studentenrollmentsystem.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.AdminHome;
import com.studentenrollmentsystem.pages.EmployeePage;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.pages.LoginPage;
import com.studentenrollmentsystem.utilities.DriverUtility;
import com.studentenrollmentsystem.utilities.ExcelUtility;


public class TestEmployeeSignUpClass extends DriverUtility{
	
	
        HomePage objHome;
		LoginPage objLogin;
		EmployeePage objEmp;
		
        @Test(priority =5, description="Validate Employee SignUp with Invalid data")
		
        public void validateEmployeeSignUpInvalid() throws IOException {
			
			
			objHome = new HomePage();
			objLogin = new LoginPage();
			//objEmp =new EmployeePage();

			// Get Data From Excel
			ArrayList<Object> data = new ArrayList<Object>();
			//Check
			data = ExcelUtility.getExcelData("Employees", 4);
			System.out.println(data);
			
	
		
				objEmp =new EmployeePage();
				
				System.out.println(data.get(0).toString());
				
				objHome.clickLogin();

				objLogin.clickRegisterAsNewEmployee();

				
				objEmp.setName(data.get(0).toString());

				objEmp.setEmail(data.get(1).toString());

				objEmp.setPassword(data.get(2).toString());

				objEmp.setRole(data.get(3).toString());

				objEmp.clickRegister();

				String expectedEmailErrorMessage = AutomationConstants.STDEMAILERRORMESSAGE;
				String actualEmailErrorMessage = objEmp.getEmailmsg();
				Assert.assertEquals(actualEmailErrorMessage, expectedEmailErrorMessage);

				String expectedPasswordErrorMessage1 = AutomationConstants.EMPLOYEEPASSWORDERROR;
				String actualPasswordErrorMessage1 = objEmp.getPasswordmsg();
				Assert.assertEquals(actualPasswordErrorMessage1, expectedPasswordErrorMessage1);

				
			   
			}

        @Test(priority = 6, enabled = true,description="Validate Employee SignUp with valid data")
		public void validtionOfEmployeeSignUp() throws IOException {

			objHome = new HomePage();
			objLogin = new LoginPage();
			//objEmp =new EmployeePage();

			// Get Data From Excel
			ArrayList<Object> name = new ArrayList<Object>();
			ArrayList<Object> email = new ArrayList<Object>();
			ArrayList<Object> password = new ArrayList<Object>();
			ArrayList<Object> role = new ArrayList<Object>();
			name = ExcelUtility.getExcelData("Employees", 0);
			System.out.println(name);
			email = ExcelUtility.getExcelData("Employees", 1);
			password = ExcelUtility.getExcelData("Employees", 2);
			role = ExcelUtility.getExcelData("Employees", 3);

			// Passing sheet name and Column number
			// System.out.println(email);
			for (int i = 0; i < email.size(); i++) {
				objEmp =new EmployeePage();
				
				System.out.println(name.get(i).toString());
				
				objHome.clickLogin();

				objLogin.clickRegisterAsNewEmployee();

				
				objEmp.setName(name.get(i).toString());

				objEmp.setEmail(email.get(i).toString());

				objEmp.setPassword(password.get(i).toString());

				objEmp.setRole(role.get(i).toString());

				objEmp.clickRegister();

				String expectedUrl1 =AutomationConstants.EMPLOYEESIGNUPURL;
			    String actualUrl1 = driver.getCurrentUrl();
				
			    Assert.assertEquals(expectedUrl1, actualUrl1);	
			}
		}
		
		
			
		}
    




