package com.studentenrollmentsystem.pages;

import java.util.List;// for courseslist

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studentenrollmentsystem.utilities.DriverUtility;

public class AdminPage extends DriverUtility{


	@FindBy(xpath = "/html/body/app-root/app-courses[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/span[1]")
	private WebElement addcourse;
	
	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[2]/a")
	private WebElement Courses;

	@FindBy(xpath = "//*[@id=\"cname\"]")
	private WebElement nameofcourse;

	@FindBy(id = "certification")
	private WebElement certification;

	@FindBy(id = "code")
	private WebElement code;

	@FindBy(id = "details")
	private WebElement details;

	@FindBy(name = "price")
	private WebElement price;

	@FindBy(name = "eligibility")
	private WebElement eligibility;

	@FindBy(name = "image")
	private WebElement image;

	@FindBy(xpath = "/html/body/app-root/app-add-course/div/div/div/div/div/div/form/div[5]/button[1]")
	private WebElement addnewcourse;

	@FindBy(xpath = "//*[@id=\"courses\"]/div/div/div[2]/div[1]/div/div/button[1]/a")
	private WebElement knowmore;
	
	
	
	@FindBy(xpath="//*[@id=\"courses\"]/div/div/div[2]/div[1]/div/div/button[2]/a")
	private WebElement editcourse;

	//@FindBy(xpath = "//*[@id=\"courses\"]/div/div/div[4]/div[1]/div/div/button[2]/a")
	//private WebElement editcourse;
	

	//@FindBy(xpath = "//*[@id=\"courses\"]/div/div/div[4]/div[1]/div")
	//private WebElement mousehover;
    
	//@FindBy(xpath = "*[@id=\"courses\"]/div/div/div[2]/div[1]/div")
	//private WebElement mousehover;


	@FindBy(xpath = "/html/body/app-root/app-update-course/div/div/div/div/div/div/form/div[5]/button[1]")
	private WebElement updatecourse;


	@FindBy(xpath = "/html/body/app-root/app-add-course/div/div/div/div/div/div/form/div[5]/button[2]")
	private WebElement resetAddcourse;



	@FindBy(xpath = "/html/body/app-root/app-update-course/div/div/div/div/div/div/form/div[5]/button[2]")
	private WebElement reset;



	@FindBy(xpath = "/html/body/app-root/app-header/section[2]/div/div[2]/ul[1]/li[6]/a")
	private WebElement search;

	@FindBy(id = "listSearch")
	private WebElement type;
	
	//courses
	@FindBy(xpath="//body/app-root[1]/app-courses[1]/section[2]/div[1]/div[1]/div")
	// "//body/app-root[1]/app-courses[1]/section[2]/div[1]/div[1]/div["+ i+ "]//div[2]/h3"
	private List <WebElement>  Courseslist ;


	public AdminPage() {
		
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	//ListCourse
	/*public String listCourses() {
		
		int n =Courseslist.size();
		for(int i=0; i<n; i++) {
		String coursename=	Courseslist.get(i).getText();
		if(coursename.equalsIgnoreCase("ETL Testing"))
			break;
		}
		return coursename;
		
	}*/

	public void clickAddNewCourse() {
		if(this.addnewcourse.isDisplayed())

		this.addnewcourse.click();

	} 

	public void clickSearch() {
		if(this.search.isDisplayed())

		this.search.click();

	} 
	public void clickResetAddcourse() throws InterruptedException {

		if(this.resetAddcourse.isEnabled())

		resetAddcourse.click();

		Thread.sleep(1000);

	} 

	public void MousehoverEdit() {
		//Instantiate Action Class        
	    Actions actions = new Actions(driver);
	    //Retrieve WebElemnt 'slider' to perform mouse hover 
		//WebElement slider = driver.findElement);
		//Move mouse to x offset 50 i.e. in horizontal direction
		actions.moveToElement(editcourse,50,0).perform();
		editcourse.click();
		//System.out.println("Moved slider in horizontal directions");
		}
  
	public void MousehoverKnowMore() {
		//Instantiate Action Class        
	    Actions actions = new Actions(driver);
	    //Retrieve WebElemnt 'slider' to perform mouse hover 
		//WebElement slider = driver.findElement);
		//Move mouse to x offset 50 i.e. in horizontal direction
		actions.moveToElement(knowmore,50,0).perform();
		knowmore.click();
		//System.out.println("Moved slider in horizontal directions");
		}
		
	public void clickUpdateCourse() {
       if(this.updatecourse.isEnabled())
		this.updatecourse.click();

	}


	public void clickAddCourse() {
		if(this.addcourse.isEnabled())
		addcourse.click();

	}

	public void clickCourses() {
		if(this.Courses.isEnabled())
		this.Courses.click();

	}

	public void setItem(String type) {

		if (this.type.isEnabled()) {
			this.type.clear();
			this.type.sendKeys(type);
		}
	}

	public void setNameOfCourse(String nameofcourse) {

		if (this.nameofcourse.isEnabled()) {
			this.nameofcourse.clear();
			this.nameofcourse.sendKeys(nameofcourse);
		}
	}

	public void setCertification(String certification) {

		if (this.certification.isEnabled()) {
			this.certification.clear();
			this.certification.sendKeys(certification);
		}
	}

	public void setCode(String code) {

		if (this.code.isEnabled()) {
			this.code.clear();
			this.code.sendKeys(code);
		}
	}

	public void setDetails(String details) {

		if (this.details.isEnabled()) {
			this.details.clear();
			this.details.sendKeys(details);
		}
	}

	public void setPrice(String price) {

		if (this.price.isEnabled()) {
			this.price.clear();
			this.price.sendKeys(price);
		}
	}

	public void setEligibility(String eligibility) {

		if (this.eligibility.isEnabled()) {
			this.eligibility.clear();
			this.eligibility.sendKeys(eligibility);
		}
	}

	public void UploadImage(String image) {

		if (this.image.isEnabled()) {
			this.image.clear();
			this.image.sendKeys(image);
		}
	}
	
}