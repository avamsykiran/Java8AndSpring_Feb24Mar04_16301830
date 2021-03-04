package com.cts.datarest.service;

import java.util.List;

import com.cts.datarest.exception.EmployeeExistsException;
import com.cts.datarest.exception.EmployeeNotFoundException;
import com.cts.datarest.model.Employee;

public interface EmployeeService {

	Employee add(Employee employee) throws EmployeeExistsException;
	Employee update(Employee employee) throws EmployeeNotFoundException;
	Employee get(Integer id);
	List<Employee> getAll();
	void delete(Integer id);
	boolean isAvailable(Integer id);
}
