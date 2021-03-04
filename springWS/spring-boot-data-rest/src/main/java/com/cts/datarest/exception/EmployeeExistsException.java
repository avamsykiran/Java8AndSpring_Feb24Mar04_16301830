package com.cts.datarest.exception;

public class EmployeeExistsException extends Exception{
	public EmployeeExistsException() {
		super("Employee witht he id already exists");
	}
}
