package com.pages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Base.TestBase;

	public class LoginPage extends TestBase {

		// Page Factory-OR:
		@FindBy(id = "//*[@id='login_logo']")
		WebElement webErp;
		
		@FindBy(id = "//*[@id=login_box']/form/div/span[1]/select")
		WebElement MywebERP;
		
		
		@FindBy(xpath = "//input[@name='UserNameEntryField']")
		WebElement username;

		@FindBy(xpath = "//input[@name='Password']")
		WebElement password;

		@FindBy(xpath = "//input[@name='SubmitUser']")
		WebElement loginBtn;

		

		// initializing the page objects:
		public LoginPage() {

			PageFactory.initElements(driver, this);

		}

		// Actions
		public String ValidateloginPageTitle() {
			return driver.getTitle();

		}

		public boolean validatwebErpImage() {

			return webErp.isDisplayed();
		}
		public String loginDropDown() {
			Select project = new Select(MywebERP);
			
			project.selectByVisibleText("My webERP");
			return driver.getTitle();
		}

		public HomePage login(String un, String pwd) {
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			return new HomePage();

		}

	}

	
	
	
	
	
	

