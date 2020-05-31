package com.hrms.testbase;


import com.hrsm.pages.AddEmployeePageElements;
import com.hrsm.pages.DashboardPageElements;
import com.hrsm.pages.LoginPageElements;
import com.hrsm.pages.PersonalDetailsPageElements;



//initializes all pages class and stores references in static varibales
//that will called/used in test classes
public class PageInitializer extends BaseClass{

	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	public static DashboardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;

	
	public static void initialize() {
	
		login=new LoginPageElements();
		dashboard=new DashboardPageElements();
		addEmp=new AddEmployeePageElements();
		pdetails=new PersonalDetailsPageElements();
	
	}
	
	}