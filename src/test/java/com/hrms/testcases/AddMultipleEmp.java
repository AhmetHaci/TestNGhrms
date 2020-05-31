package com.hrms.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;

public class AddMultipleEmp extends CommonMethods {

	

	@Test (dataProvider = "getData", groups= "smoke")
	public void addMultipleEmp(String name, String lastname, String username, String password, String screenshot) {
	
		login.adminLogin();
		dashboard.navigateToAddEmployee();

		sendText(addEmp.firstName, name);
		sendText(addEmp.lastName, lastname);

		jsClick(addEmp.chkLoginDetails);
		sendText(addEmp.newEmpUsername, username);
		sendText(addEmp.newEmpPassword, password);
		sendText(addEmp.confirmPassword, password);
		Select select = new Select(addEmp.status);
		select.selectByVisibleText("Enabled");

		jsClick(addEmp.saveBtn);

		takesScreenshot(screenshot);
		String actaulString = pdetails.verifyEmp.getText();
		String expected = name + " " + lastname;

		Assert.assertEquals(actaulString, expected, "mismatch");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = { 
				{ "Mehmet", "Cakmak", "Mehmetcak741", "8C!C*aZp^VcUaE","screenshot/HRMS/Employee1.png" },
				{ "Said", "Ikbal", "IkbalSaid10", "4SYN3F#@RnQnvy","screenshot/HRMS/Employee2.png" },
				{ "Farzan", "Makhir", "Farzan568", "$72%dNHPsJ6VEH","screenshot/HRMS/Employee3.png" },
				{ "Huseyin", "Sen", "Huseyin456", "aQby@8azWbyR@P","screenshot/HRMS/Employee4.png" },
				{ "Izzet", "Salih", "IzzetSalih10", "FVq#4yQX39W498","screenshot/HRMS/Employee5.png" },
				{ "Murat", "Akif", "AkifMurat50", "2LbFX1wv$@#jAc","screenshot/HRMS/Employee6.png" }

		};

		return data;

	}

}
