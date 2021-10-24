package com.employeeapi.testcase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

public class TC_002_GET_SNG_EMP_DATA extends TestBase{
// This is the testcase for the Signle Employee validation
	public Validation validation = new Validation();
	String statusLineExpected="HTTP/1.1 200 OK";
	int statusCodeExpected=200;
	String contentTypeExpected="application/json";
	String serverTypeExpected="cloudflare";
	String contentEncodingExpected="gzip";
	long contentLengthExpected=100;
	long responseTimeExpect=2000;	
	
	@BeforeClass
	public void getSngEmpData() throws InterruptedException {	
		extendUri="/employee/9";
		//http://dummy.restapiexample.com/api/v1/employee/9
		//https://dummy.restapiexample.com/api/v1/employee/9
		RestAssured.baseURI=baseUri;
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET, extendUri);
		testCaseName="TC_002_GET_SNG_EMP_DATA";
		logger.info("*********Started"+ testCaseName +"**********");
		Thread.sleep(200);		
	}
	@Test
	public void validationBody() {
		validation.validationResponseBody(response);
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
//	@Test
//	public void validationContentLength() {
//		validation.validationcontentLength(response, null);
//	}
	@AfterClass
	public void tearDown() {
		logger.info("<<<<<<<<<< END "+testCaseName+">>>>>>>>>>>>>>");
	}
}
