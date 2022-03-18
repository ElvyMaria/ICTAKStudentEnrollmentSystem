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
	
	// Validate Home Link
	
	@Test(priority=18 )
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
	@Test(priority=19 )
	public void validateShowMoreButton() throws IOException, InterruptedException {
		
		objHome = new HomePage();
		objHome.clickHome();
		objHome.clickShowMore();
		String expectedURL = AutomationConstants.COURSESPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	@Test(priority =20 )
	public void validateCourseLink() throws IOException  {
		
		objHome = new HomePage();
		objHome.clickCourse();
		String expectedURL = AutomationConstants.COURSESPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	@Test(priority = 21)
	public void validateLoginButton() throws IOException, InterruptedException {
		objHome = new HomePage();
		Thread.sleep(1000);
		objHome.clickLogin();
		String expectedURL = AutomationConstants.LOGINPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	@Test(priority = 22)
	public void validateKnowMoreButton() throws IOException{
		
		objHome = new HomePage();
		objHome.clickKnowMore();
		String expectedURL = AutomationConstants.COURSEPAGEURL;
		String actualURL=driver.getCurrentUrl();
		//System.out.println(expectedURL);
		Assert.assertEquals(actualURL,expectedURL);
		
	}
	
	
	

}