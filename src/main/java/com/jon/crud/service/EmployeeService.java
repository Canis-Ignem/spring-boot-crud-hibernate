package com.jon.crud.service;

import java.util.List;

import com.jon.crud.Entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int employeeId);
	
	public void save(Employee employee);
	
	public void deleteById(int employeeId);

}
