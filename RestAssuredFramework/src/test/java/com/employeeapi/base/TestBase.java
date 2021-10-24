package com.employeeapi.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.employeeapi.testcase.Validation;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static String extendUri="";
	public String empID="24";
	public static String baseUri="https://dummy.restapiexample.com/api/v1";//http://dummy.restapiexample.com/api/v1/employees
	public Logger logger=Logger.getLogger("EmployeeRestAPI");
//	public Validation validation =new Validation();
	public static String testCaseName="";
			
	@BeforeTest
	public void setup() {
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);		
		logger.info("<<<<<<<<<< NEW Testing Start>>>>>>>>>>>>>>");
	}
	

}
