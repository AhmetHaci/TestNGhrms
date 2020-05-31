package com.hrms.testcases;




import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {

//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}

	@Test
	public void addEmployeePage() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(7);
		
//		sendText(addEmp.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
//		sendText(addEmp.empLastName, ConfigsReader.getProperty("employeeLastname"));
//		sendText(addEmp.addPhoto, ConfigsReader.getProperty("filePath"));
//		waitAndClick(addEmp.saveEmp);
		
		//add assertion to verify that employee has been added successfully
		
		
	}

}