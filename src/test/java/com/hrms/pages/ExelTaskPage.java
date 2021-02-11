package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class ExelTaskPage {

	@FindBy(id = "txtUsername")
	public WebElement username;
	@FindBy(name = "txtPassword")
	public WebElement password;
	@FindBy(id = "btnLogin")
	public WebElement loginBtn;
	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;

	@FindBy(id = "btnAdd")
	public WebElement AddEmployee;

	@FindBy(id = "firstName")
	public WebElement firstName;
	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "btnSave")
	public WebElement SaveBtn;
	
	
	@FindBy(xpath = "//*[@id='employee-details']/div/div[@id='profile-pic']")
	public WebElement VerifyName;
	

	public ExelTaskPage() {
		PageFactory.initElements(Driver.getDriver(), this);

	}
}
