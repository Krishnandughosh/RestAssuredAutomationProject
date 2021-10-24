package com.employeeapi.testcase;

import com.employeeapi.base.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_001_GET_ALL_EMP extends TestBase{
	
	public Validation validation =new Validation();
	String statusLineExpected="HTTP/1.1 200 OK";
	int statusCodeExpected=200;
	String contentTypeExpected="application/json";
	String serverTypeExpected="cloudflare";
	String contentEncodingExpected="gzip";
	long contentLengthExpected=100;
	long responseTimeExpect=2000;
	
	@BeforeClass
	public void getAllEmpData() throws InterruptedException {	
		extendUri="/employees";
		testCaseName="TC001_Get_All_Employees";
		logger.info("*********Started"+testCaseName+"**********");
		
		RestAssured.baseURI=baseUri;
		httpRequest=RestAssured.given();		
		response=httpRequest.request(Method.GET, extendUri);		
		Thread.sleep(200);		
	}
	
	@Test
	public void validationBody() {
		validation.validationResponseBody(response);
	}
	
	@Test
	public void validationCode() {
		
		validation.validationStatusCode(response,statusCodeExpected);
	}
	@Test
	public void validationStatusLine() {
		
		validation.validationStatusLine(response,statusLineExpected);
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
	public void validationEncoding() {
		
		validation.validationContentEncoding(response, contentEncodingExpected);
	}
	@Test
	public void validationLength() {
		
		validation.validationcontentLength(response, contentLengthExpected);
	}		
@AfterClass
	public void tearDown() {
		logger.info("<<<<<<<<<< END "+testCaseName+">>>>>>>>>>>>>>");
	}
	
}
