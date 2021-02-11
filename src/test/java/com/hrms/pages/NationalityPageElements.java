package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class NationalityPageElements {



//	Click on Nationality Tab and enter Country
//	Click on Add button and save button
//	User Sees the country added  and its in the list

	@FindBy(id = "menu_admin_nationality")
	public WebElement natioinalityBtn;
	
	@FindBy(id = "btnAdd")
	public WebElement addBtn;
	
	
	@FindBy(name = "nationality[name]")
	public WebElement nationalTexBox;
	

	@FindBy(id = "btnSave")
	public WebElement saveBTn;
	
	
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[*]")
	public List<WebElement> nationalityList;
	
	@FindBy(id = "resultTable")
	public WebElement Table;
	

	
	
	
	
	 public NationalityPageElements() {
		 
		PageFactory.initElements(Driver.getDriver(), this); 
		 
	 }
	
}
