package com.hrsm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(xpath = "//input[@id='employeeId']")
	public WebElement EmpId;

	@FindBy(id = "photofile")
	public WebElement uploadPhoto;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	@FindBy(className = "hasTopFieldHelp")
	public WebElement fullName;

	@FindBy(id = "empPic")
	public WebElement photo;

	@FindBy(id = "chkLogin")
	public WebElement chkLoginDetails;

	@FindBy(id = "user_name")
	public WebElement newEmpUsername;

	@FindBy(id = "user_password")
	public WebElement newEmpPassword;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;

	@FindBy(id = "status")
	public WebElement status;

	@FindBy(xpath = "//span[@for='firstName']")
	public WebElement requiredfName;

	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void addNewEmp(String name, String lName ) {
		sendText(firstName, name);
		sendText(lastName, lName);
		sendText(uploadPhoto, ConfigsReader.getProperty("pictureFilePath"));

	}

	public void chkLoginDetails() {

		chkLoginDetails.click();
		sendText(newEmpUsername, ConfigsReader.getProperty("newEmpUsername"));
		sendText(newEmpPassword, ConfigsReader.getProperty("newEmpPassword"));
		sendText(confirmPassword, ConfigsReader.getProperty("newEmpPassword"));
		Select select = new Select(status);
		select.selectByVisibleText("Enabled");
		saveBtn.click();
	}

}
