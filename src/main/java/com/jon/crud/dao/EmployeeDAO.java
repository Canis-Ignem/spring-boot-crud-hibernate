package com.jon.crud.dao;

import java.util.List;

import com.jon.crud.Entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	public Employee findByid(int employeeId);
	public void save(Employee employee);
	public void deleteById(int employeeId);
}
