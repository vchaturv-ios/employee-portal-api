package com.vish.employee.portal.api.service;

import java.util.List;

import com.vish.employee.portal.api.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployeeDetails();
	
	public Employee createEmployee(Employee employee);

}
