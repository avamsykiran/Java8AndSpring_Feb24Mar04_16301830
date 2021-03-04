package com.cts.datarest.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.datarest.exception.EmployeeExistsException;
import com.cts.datarest.exception.EmployeeNotFoundException;
import com.cts.datarest.model.Employee;
import com.cts.datarest.service.EmployeeService;

@RestController
@RequestMapping("/emps")
public class EmployeeApi {

	@Autowired
	private EmployeeService empService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<List<Employee>>(empService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") int id) {

		ResponseEntity<Employee> result = null;

		Employee emp = empService.get(id);

		if (emp == null) {
			result = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			result = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}

		return result;
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		ResponseEntity<Employee> result = null;

		try {
			emp = empService.add(emp);
			result = new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		} catch (EmployeeExistsException e) {
			result = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
		}

		return result;
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		ResponseEntity<Employee> result = null;

		try {
			emp = empService.update(emp);
			result = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			result = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		return result;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {

		ResponseEntity<Void> result = null;

		if (empService.isAvailable(id)) {
			empService.delete(id);
			result = new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			result = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return result;
	}
}
