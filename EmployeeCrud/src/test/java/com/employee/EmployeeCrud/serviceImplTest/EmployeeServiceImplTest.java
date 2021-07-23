package com.employee.EmployeeCrud.serviceImplTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.EmployeeCrud.dto.Employee;
import com.employee.EmployeeCrud.repository.IEmployeeRepository;
import com.employee.EmployeeCrud.serviceimpl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {
	IEmployeeRepository employeeRepository;
	EmployeeServiceImpl employeeService;
	Employee employee;

	@BeforeEach
	void setUp() {
		employeeService = new EmployeeServiceImpl();
		employee = new Employee();
		employee.setEmployeeName("bharath");
		employee.setOccupation("Analyst");
		employee.setPhoneno("9603038006");
		employee.setSalary(21000.0);

	}

	@AfterEach
	void clear() {
		//employeeRepository.deleteAll();
	}

	@Test
	void addEmployeeTest() {
		Employee returnedObject = employeeRepository.save(employee);
		Assertions.assertEquals("bharath", returnedObject.getEmployeeName());
		Assertions.assertEquals("Analyst", returnedObject.getOccupation());
		Assertions.assertEquals("9603038006", returnedObject.getPhoneno());
		Assertions.assertEquals(21000.0, returnedObject.getSalary());

	}
}
