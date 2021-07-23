package com.employee.EmployeeCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeCrud.dto.Employee;
import com.employee.EmployeeCrud.exception.EmployeeNotFoundException;
import com.employee.EmployeeCrud.serviceimpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
	}
	@PutMapping("/updateemployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK); 
	}
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);	
	}
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		return new ResponseEntity<>(employeeService.viewById(id),HttpStatus.OK);
	}
	@GetMapping("/getemployeebysalaryasc")
	public ResponseEntity<List<Employee>> getEmployeeSalaryByAsc()
	{
		return new ResponseEntity<>(employeeService.viewEmployeeBySalaryAsc(),HttpStatus.OK);
	}
	@GetMapping("/getemployeebysalarydesc")
	public ResponseEntity<List<Employee>> getEmployeeSalaryByDesc()
	{
		return new ResponseEntity<>(employeeService.viewEmployeeBySalarydesc(),HttpStatus.OK);
	}
	

}
