package com.jon.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jon.crud.Entity.Employee;
import com.jon.crud.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return this.employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		return this.employeeDAO.findByid(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		this.employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		this.employeeDAO.deleteById(employeeId);

	}

}
