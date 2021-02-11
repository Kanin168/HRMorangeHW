package com.hrms.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.AdminPageElement;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.NationalityPageElements;
import com.hrms.testBase.ConfigsReader;
import com.hrms.testBase.Driver;

public class nationalities_test {

 
	

	public class loginTest {

		LoginPageElements loginPageObject = new LoginPageElements();
		DashboardPageElements dashBoardObject = new DashboardPageElements();
		AdminPageElement adminObject = new AdminPageElement();
		NationalityPageElements nationalityObject = new NationalityPageElements();
		
		
		@BeforeMethod
		public void setUp() {

			Driver.getDriver().get(ConfigsReader.getProperty("url"));
			Driver.getDriver().manage().window().maximize();
			Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		@Test
		public void loginTestUsingPOM() {

			loginPageObject.username.sendKeys(ConfigsReader.getProperty("validUsername"));
			loginPageObject.password.sendKeys(ConfigsReader.getProperty("validPassword"));
			loginPageObject.loginBtn.click();
			
//			System.out.println(dashBoardObject.subscriberLinkText.getAttribute("value"));
//			Assert.assertEquals(dashBoardObject.subscriberLinkText.getAttribute("value"), "Subscribe");
			 

//			Navigate to Admin Page
//			Click on Nationality Tab and enter Country
//			Click on Add button and save button
//			User Sees the country added  and its in the list
			
			
			dashBoardObject.AdminBtn.click();
			nationalityObject.natioinalityBtn.click();
			nationalityObject.addBtn.click();
			nationalityObject.nationalTexBox.sendKeys(ConfigsReader.getProperty("nationalName"));
			nationalityObject.saveBTn.click();
			
//			for (WebElement eachCountry : nationalityObject.nationalityList) {
//				
//			System.out.println(eachCountry.getText());
//			}
				
				
			String ExpectedText = "ChiangMai";
			
		 
			
 			String ActualList = nationalityObject.Table.getText();

			
			Assert.assertTrue(ActualList.contains(ExpectedText));
			
			
			nationalityObject.saveBTn.click();
			
		}
	
	
	
	
	
	
	
	
	}
	
}

