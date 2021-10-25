package com.employeeapi.utilities;
import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilites {
	
	public String empId() {
		String empId=RandomStringUtils.randomNumeric(5);
		return empId;
	}
	
	public String empName() {
		String empName="John"+RandomStringUtils.randomAlphabetic(2);
		return empName;
	}

	public String empAge() {
		String empAge=RandomStringUtils.randomNumeric(2);
		return empAge;
	}
	public String empSal() {
		String empSal=RandomStringUtils.randomNumeric(5);
		return empSal;
	}
}
