package com.cts.datarest.exception;

public class EmployeeNotFoundException extends Exception{
	public EmployeeNotFoundException() {
		super("NBo Such Employee Found");
	}
}
