package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class AdminPageElement {
	
	
	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement natioinalityBtn;
	
	
	
	
	
	
	
	public AdminPageElement() {
		 
		PageFactory.initElements(Driver.getDriver(), this); 
	
	
	
	

}

	
}