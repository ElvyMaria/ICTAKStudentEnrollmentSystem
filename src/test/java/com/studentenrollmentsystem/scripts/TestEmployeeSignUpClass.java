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
		
		//Registration function for Employee 

        @Test(priority = 5, enabled = true)
		public void validtionofEmployeeSignUp() throws IOException {

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


