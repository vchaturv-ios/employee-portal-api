package com.vish.employee.portal.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vish.employee.portal.api.model.Employee;
import com.vish.employee.portal.api.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value="EmployeeController", description="Employee portal related Operations")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	@ApiOperation(value = "View a list of All Employees", response = List.class)
	public List<Employee> getAllEmployeeDetails() {
		return employeeService.getAllEmployeeDetails();
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Register a employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		Employee emp = null;
		if(Optional.ofNullable(employee).isPresent()) {
			emp = employeeService.createEmployee(employee);
		}
		return emp;
	}
}
