package com.nagarro.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.springrest.dao.EmployeeDAO;
import com.nagarro.springrest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//	List<Employee> employees;

	@Autowired
	private EmployeeDAO dao;

	public EmployeeServiceImpl() {

//		employees = new ArrayList<>();
//		employees.add(new Employee(500, "Jp", "Delhi", "jjena@gmail.com", "22Nov1998"));

	}

	@Override
	public List<Employee> getEmployees() {
		return dao.findAll();
	}

	@Override
	public Employee getEmployee(long empId) {
		Employee emp = null;
//		for (Employee employee : employees) {
//			if (employee.getEmpCode() == empId) {
//				emp = employee;
//				break;
//			}
//		}
		return dao.findById(empId).get();
	}

	@Override
	public Employee addEmployee(Employee emp) {
//		employees.add(emp);
		dao.save(emp);
		return emp;
	}

	@Override
	public void deleteEmployee(long empId) {
		Optional<Employee> emp = dao.findById(empId);
		dao.deleteById(empId);

	}

	@Override
	public Employee updateEmployee(Employee emp) {
		dao.save(emp);
		return emp;
	}

}
