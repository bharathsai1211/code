package com.employee.EmployeeCrud.service;

import java.util.List;

import com.employee.EmployeeCrud.dto.Employee;
import com.employee.EmployeeCrud.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int id) throws EmployeeNotFoundException;
	public Employee viewById(int id) throws EmployeeNotFoundException;
	public List<Employee> viewEmployeeBySalaryAsc();
	public List<Employee> viewEmployeeBySalarydesc(); 

}
