package com.cts.datarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.datarest.exception.EmployeeExistsException;
import com.cts.datarest.exception.EmployeeNotFoundException;
import com.cts.datarest.model.Employee;
import com.cts.datarest.repos.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Employee add(Employee employee) throws EmployeeExistsException {
		if(empRepo.existsById(employee.getEmpId())) {
			throw new EmployeeExistsException();
		}
		return empRepo.save(employee);
	}

	@Override
	public Employee update(Employee employee) throws EmployeeNotFoundException {
		if(!empRepo.existsById(employee.getEmpId())) {
			throw new EmployeeNotFoundException();
		}
		return empRepo.save(employee);
	}

	@Override
	public Employee get(Integer id) {
		return empRepo.findById(id).orElse(null);
	}

	@Override
	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	@Override
	public void delete(Integer id) {
		empRepo.deleteById(id);
	}

	@Override
	public boolean isAvailable(Integer id) {
		return empRepo.existsById(id);
	}

}
