package com.nagarro.springrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.springrest.model.Employee;
import com.nagarro.springrest.services.EmployeeService;

@RestController
public class MyController {

	// autowired used for injecting object automatically
	@Autowired
	EmployeeService service;

	@GetMapping("/home")
	public String home() {
		return "Welcome to rest api";
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return service.getEmployees();
	}

	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		return service.getEmployee(empId);
	}

	@PostMapping(path = "/employees", consumes = "application/json")
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}

	@PutMapping(path = "/employees", consumes = "application/json")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}

	@DeleteMapping("employees/{empId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int empId) {
		try {
			service.deleteEmployee(empId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
