package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class DashboardPageElements {
	
	
//	@FindBy(id = "welcome")
//	public WebElement welcome;
//	@FindBy(xpath = "")
//	public WebElement logo;
//	@FindBy(xpath = "")
//	public WebElement addEmp;
	@FindBy(id = "Subscriber_link")
	public WebElement subscriberLinkText;
	
	@FindBy(id = "")
	public WebElement empListPage;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement AdminBtn;
	
	
	
	
	
	
	
	
	
	
	public List<WebElement> dashMenu;
	public DashboardPageElements() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	public void navigateToAddEmployee() {
	}
	
	
	
	
	
	
	
	
	

}
