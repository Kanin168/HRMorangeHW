package com.hrms.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.ExelTaskPage;
import com.hrms.testBase.ConfigsReader;
import com.hrms.testBase.Driver;

public class LoginByExell {

	FileInputStream fs;
	DataFormatter objDefaultFormat;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	ExelTaskPage exel;

	@BeforeMethod
	public void setUp() {

		Driver.getDriver().get(ConfigsReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginExel() throws IOException, InterruptedException {

		fs = new FileInputStream("OrangeLoginExell.xlsx");
		objDefaultFormat = new DataFormatter();
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		exel = new ExelTaskPage();

		Cell Admin = sheet.getRow(1).getCell(0);
		String orderID1 = Admin.toString();

		Cell admin123 = sheet.getRow(1).getCell(1);
		String orderID2 = admin123.toString();

		Cell Kanin = sheet.getRow(1).getCell(2);
		String orderID3 = Kanin.toString();

		Cell Roy = sheet.getRow(1).getCell(3);
		String orderID4 = Roy.toString();

		exel.username.sendKeys(orderID1);
		exel.password.sendKeys(orderID2);
		exel.loginBtn.click();

		exel.PIM.click();

		Thread.sleep(2000);
		exel.AddEmployee.click();
		Thread.sleep(2000);

		exel.firstName.sendKeys(orderID3);

		exel.lastName.sendKeys(orderID4);

		exel.SaveBtn.click();

		String verify = exel.VerifyName.getText();
		String verifyExpected = "Kanin Roy";
		System.out.println(verify);
		assertEquals(verify, verifyExpected);

//	    https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList
//	    click pim 
//	    click add imployee tab 
//	    verify 

//	    System.out.println( orderID1  );
//	    System.out.println( orderID2  );
//	    System.out.println( orderID3  );
//	    System.out.println( orderID4  );
//	    

//		exel.username.sendKeys(ConfigsReader.getProperty("validUsername"));
//		exel.password.sendKeys(ConfigsReader.getProperty("validPassword"));
//		exel.loginBtn.click();

	}

}
