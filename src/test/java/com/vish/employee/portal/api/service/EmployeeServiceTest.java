package com.vish.employee.portal.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.vish.employee.portal.api.enums.Gender;
import com.vish.employee.portal.api.model.Employee;
import com.vish.employee.portal.api.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeServiceImpl service = new EmployeeServiceImpl();
	
	@Mock
	EmployeeRepository employeeRepo;
	
	Employee employee = new Employee();
	List<Employee> employees = new ArrayList<>();
	
	@Before
	public void setup() throws ParseException {
		MockitoAnnotations.initMocks(this);
		employee.setFirstName("Vishnu");
		employee.setLastName("Chaturvedi");	
		employee.setGender(Gender.MALE);
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("10-02-1995"));
		employee.setDepartment("Platform Engineering");
		employees.add(employee);
	}
	
	@Test
	public void createEmployeeTest() {
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		assertNotNull(employee);
		assertNotNull(service.createEmployee(employee));
		assertEquals("Vishnu", service.createEmployee(employee).getFirstName());
	}
	
	@Test
	public void getAllEmployeeDetailsTest() {
		Mockito.when(employeeRepo.findAll()).thenReturn(employees);
		assertNotNull(employees);
		assertEquals(employees,service.getAllEmployeeDetails());
	}

}
