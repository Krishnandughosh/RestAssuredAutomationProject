package com.employeeapi.testcase;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtilites;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_003_POST_NEW_EMP extends TestBase {
	RestUtilites rest=new RestUtilites();
	Validation validation=new Validation();
	String employee_id=rest.empId();
	String employee_name=rest.empName();
	String employee_salary=rest.empSal();
	String employee_age=rest.empAge();
	String profile_image="";
	String statusLineExpected="HTTP/1.1 200 OK";
	int statusCodeExpected=200;
	String contentTypeExpected="application/json";
	String serverTypeExpected="cloudflare";
	String contentEncodingExpected="gzip";
	long responseTimeExpect=2000;	
	@BeforeClass
	public void postNewemp() throws InterruptedException {
		testCaseName="TC_003_POST_NEW_EMP";
		logger.info("*********Started"+ testCaseName +"**********");
		//https://dummy.restapiexample.com/api/v1/create
		extendUri="/create";
		RestAssured.baseURI=baseUri;
		httpRequest= RestAssured.given() ;
		JSONObject requestParam=new JSONObject();
		requestParam.put("id",employee_id);
		requestParam.put("employee_name",employee_name);
		requestParam.put("employee_salary",employee_salary);
		requestParam.put("employee_age",employee_age);
		requestParam.put("profile_image",profile_image);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		
		response=httpRequest.request(Method.POST,extendUri);
		Thread.sleep(200);		
	}

	@Test
	public void validationBody() {
		validation.validationResponseBody(response);
	}
	
	@Test
	public void validationResponsePost() {
		validation.validationResponsePost(response, employee_name);
		
	}
	
	@Test
	public void validationStatusCode() {
		validation.validationStatusCode(response, statusCodeExpected);
	}
	@Test 
	public void validationStatusLine() {
		validation.validationStatusLine(response, statusLineExpected);
	}
	@Test
	public void validationResponseTime() {
		validation.validationResponseTime(response, responseTimeExpect);
	}
	@Test
	public void validationContentType() {
		validation.validationContentType(response, contentTypeExpected);
	}
	@Test
	public void validationServerType() {
		validation.validationServerType(response, serverTypeExpected);		
	}
	@Test
	public void validationContentEncoding() {
		validation.validationContentEncoding(response, contentEncodingExpected);
	}

	@AfterClass
	public void tearDown() {
		logger.info("<<<<<<<<<< END "+testCaseName+">>>>>>>>>>>>>>");
	}
	

}

//"id":9,"employee_name":"Colleen Hurst","employee_salary":205500,"employee_age":39,"profile_image":""