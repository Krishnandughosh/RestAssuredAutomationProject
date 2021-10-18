package com.employeeapi.testcase;

import org.testng.Assert;

import com.employeeapi.base.TestBase;

import io.restassured.response.Response;


public class Validation extends TestBase {
	String failMsg="";
	String PassMsg="";
	String msg="";
		
		public void validationResponseBody(Response response) {
			logger.info("##validationResponseBody##");
			String reponseBody=response.getBody().asString();	
			failMsg="-->FAIL<-- " +msg ;
			PassMsg="**PASS** "+ msg;
			if (reponseBody!=null) {
				logger.info(PassMsg);
			} else {
				logger.debug(failMsg);
			}
			Assert.assertTrue(reponseBody!=null,failMsg);
		}		
		public void validationStatusCode(Response response,int statusCodeExpected) {
			logger.info("##validationStatusCode##");
			int statusCodeAcutal=response.getStatusCode();	
			failMsg="-->FAIL<-- statusCodeAcutal "+statusCodeAcutal;
			PassMsg="**PASS** statusCodeAcutal -> "+ statusCodeAcutal;
			
			if (statusCodeAcutal==statusCodeExpected) {
				logger.info(PassMsg);			
			} else {
				logger.debug(failMsg);
			}
			Assert.assertEquals(statusCodeAcutal, statusCodeExpected,failMsg);
		}
		public void validationStatusLine(Response response,String statusLineExpected) {
			logger.info("##validationStatusLine##");
			String statusLineActual=response.getStatusLine().toString();	
			msg="statusLineActual "+ statusLineActual;
			failMsg="-->FAIL<-- " +msg ;
			PassMsg="**PASS** "+ msg;
			if (statusLineExpected.equals(statusLineActual)) {
				logger.info(PassMsg);			
			} else {
				logger.debug(failMsg);
			}
			Assert.assertEquals(statusLineActual, statusLineExpected,failMsg);
					
		}
		public void validationResponseTime(Response response,Long responseTimeExpect)  {
			logger.info("##validationResponseTime##");
			long responseTimeActual=response.getTime();		
			msg="responseTimeActual "+ responseTimeActual;
			failMsg="-->FAIL<-- " +msg ;
			PassMsg="**PASS** "+ msg;			
			if (responseTimeActual<responseTimeExpect) {
				logger.info(PassMsg);			
			} else {
				logger.debug(failMsg);
			}
			Assert.assertTrue(responseTimeActual<responseTimeExpect,failMsg);
			
		}
		public void validationContentType(Response response,String contentTypeExpected)  {
			logger.info("##validationContentType##");
			String contentTypeActual=response.header("Content-Type").toString();
			msg="contentTypeActual "+ contentTypeActual;
			failMsg="-->FAIL<-- " +msg ;
			PassMsg="**PASS** "+ msg;			
			if (contentTypeActual.equals(contentTypeExpected)) {
				logger.info(PassMsg);			
			} else {
				logger.debug(failMsg);
			}
			Assert.assertEquals(contentTypeActual, contentTypeExpected);
			
		}
		public void validationServerType(Response response,String serverTypeExpected)  {
			logger.info("##validationContentType##");
			String serverTypeActual=response.header("Server").toString();
			msg="serverTypeActual "+ serverTypeActual;
			failMsg="-->FAIL<-- " +msg ;
			PassMsg="**PASS** "+ msg;			
			if (serverTypeActual.equals(serverTypeExpected)) {
				logger.info(PassMsg);			
			} else {
				logger.debug(failMsg);
			}
			Assert.assertEquals(serverTypeActual, serverTypeExpected);
			
		}
		public void validationContentEncoding(Response response,String contentEncodingExpected)  {
			logger.info("##validationContentType##");
			String contentEncodingActual=response.header("Content-Encoding").toString();
			msg="contentEncodingActual "+ contentEncodingActual;
			failMsg="-->FAIL<-- " +msg ;
			PassMsg="**PASS** "+ msg;			
			if (contentEncodingActual.equals(contentEncodingExpected)) {
				logger.info(PassMsg);			
			} else {
				logger.debug(failMsg);
			}
			Assert.assertEquals(contentEncodingActual, contentEncodingExpected);
			
		}
		public void validationcontentLength(Response response,Long contentLengthExpected)  {
			logger.info("##validationcontentLength##");
			long responseTimeActual=response.getTime();		
			String contentLengthActualString=response.header("Content-Length").toString();
			Long contentLengthActual= Long.parseLong(contentLengthActualString);
			msg="responseTimeActual "+ responseTimeActual;
			failMsg="-->FAIL<-- " +msg ;
			PassMsg="**PASS** "+ msg;			
			if (contentLengthActual>contentLengthExpected) {
				logger.info(PassMsg);			
			} else {
				logger.debug(failMsg);
			}
			Assert.assertTrue(responseTimeActual>contentLengthExpected,failMsg);
			
		}		
}

