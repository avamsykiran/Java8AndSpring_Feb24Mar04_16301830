package com.cts.fsw.service;

import org.springframework.stereotype.Service;

import com.cts.fsw.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee computeAllowences(Employee e) {
		e.setHra(e.getBasic()*0.23);
		e.setTa(e.getBasic()*0.13);
		return e;
	}

}
