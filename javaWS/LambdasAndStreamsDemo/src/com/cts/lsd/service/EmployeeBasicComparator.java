package com.cts.lsd.service;

import java.util.Comparator;

import com.cts.lsd.model.Employee;

public class EmployeeBasicComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return ((Double)o1.getBasic()).compareTo(o2.getBasic());
	}
	
	

}
