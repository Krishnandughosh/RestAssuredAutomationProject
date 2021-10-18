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
	@BeforeTest
		public void getAllEmpData() throws InterruptedException {
//		http://dummy.restapiexample.com/api/v1/employees		
		extendUri="/employees";
		testCaseName="TC001_Get_All_Employees";
		logger.info("*********Started"+testCaseName+"**********");
		
		RestAssured.baseURI=baseUri;
		httpRequest=RestAssured.given();		
		response=httpRequest.request(Method.GET, extendUri);		
		Thread.sleep(50);		
	}
	
	@Test
	public void validationBody() {
		validation.validationResponseBody(response);
	}
	
	@Test
	public void validationCode() {
		int statusCodeExpected=200;
		validation.validationStatusCode(response,statusCodeExpected);
	}
	@Test
	public void validationLine() {
		String statusLineExpected="HTTP/1.1 200 OK";
		validation.validationStatusLine(response,statusLineExpected);
	}
	
	@Test
	public void validationTime() {
		long responseTimeExpect=2000;
		validation.validationResponseTime(response, responseTimeExpect);
	}
	
	@Test
	public void validationContent() {
		String contentTypeExpected="application/json";
		validation.validationContentType(response, contentTypeExpected);
	}
	
	@Test
	public void validationServer() {
		String serverTypeExpected="cloudflare";
		validation.validationServerType(response, serverTypeExpected);
	}
	
	@Test
	public void validationEncoding() {
		String contentEncodingExpected="gzip";
		validation.validationContentEncoding(response, contentEncodingExpected);
	}
	@Test
	public void validationLength() {
		long contentLengthExpected=100;
		validation.validationcontentLength(response, contentLengthExpected);
	}		
@AfterTest
	public void tearDown() {
		logger.info("<<<<<<<<<< END "+testCaseName+">>>>>>>>>>>>>>");
	}
	
}
