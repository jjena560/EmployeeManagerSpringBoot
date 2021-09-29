package com.nagarro.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.springrest.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

}
