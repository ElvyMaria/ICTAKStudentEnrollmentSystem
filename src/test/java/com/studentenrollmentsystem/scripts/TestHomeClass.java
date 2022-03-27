package com.studentenrollmentsystem.scripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studentenrollmentsystem.constants.AutomationConstants;
import com.studentenrollmentsystem.pages.HomePage;
import com.studentenrollmentsystem.utilities.DriverUtility;
import com.studentenrollmentsystem.utilities.PageUtility;

public class TestHomeClass extends DriverUtility {
	
	HomePage objHome;
	
	
	@Test(priority=19,description=" Validate Home Link" )
	public void validateHomeLink() throws IOException {
		objHome = new HomePage();
		objHome.clickHome();
		
		String expectedURL = AutomationConstants.HOMEPAGEURL;
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL,expectedURL);
		
		//objHome.clickGoThroughCourse();
		
		/*objHome.clickGoThroughCourse();
		String expectedURL1 = AutomationConstants.COURSESPAGEURL;
		String actualURL1=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL1,expectedURL1);*/
		
	
	}
	
	//
	@Test(priority=20 ,description=" Validate ShowMoreButton in Home Page")
	public void validateShowMoreButton() throws IOException, InterruptedException {
		
		objHome = new HomePage();
		objHome.clickHome();
		objHome.clickShowMore();
		String expectedURL = AutomationConstants.COURSESPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	@Test(priority =21 ,description=" Validate CourseLink in Home Page")
	public void validateCourseLink() throws IOException  {
		
		objHome = new HomePage();
		objHome.clickCourse();
		String expectedURL = AutomationConstants.COURSESPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	@Test(priority = 22,description=" Validate Login Button in Home Page")
	public void validateLoginButton() throws IOException, InterruptedException {
		objHome = new HomePage();
		Thread.sleep(1000);
		objHome.clickLogin();
		String expectedURL = AutomationConstants.LOGINPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	@Test(priority = 23,description=" Validate KnowMore Button in Home Page")
	public void validateKnowMoreButton() throws IOException{
		
		objHome = new HomePage();
		objHome.clickKnowMore();
		String expectedURL = AutomationConstants.COURSEPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	
	

}