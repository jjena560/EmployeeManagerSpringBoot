package com.nagarro.springrest.services;

import java.util.List;

import com.nagarro.springrest.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Employee getEmployee(long empId);

	public Employee addEmployee(Employee emp);

	public void deleteEmployee(long empId);

	public Employee updateEmployee(Employee emp);
}
