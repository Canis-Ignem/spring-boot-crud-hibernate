package com.jon.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jon.crud.Entity.Employee;
import com.jon.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return this.employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee employee = this.employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Couldn't find Employee with Id: " + employeeId);
		}

		return this.employeeService.findById(employeeId);
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		this.employeeService.save(employee);
		return employee;
	}

	@PutMapping("/employees")
	public Employee getEmployees(@RequestBody Employee employee) {
		this.employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee employee = this.employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Couldn't find Employee with Id: " + employeeId);
		}
		this.employeeService.deleteById(employeeId);
		
		return "Deleted Employee with id: " + employeeId;
	}
}
