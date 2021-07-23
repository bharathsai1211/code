package com.employee.EmployeeCrud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.EmployeeCrud.dto.Employee;
import com.employee.EmployeeCrud.exception.EmployeeNotFoundException;
import com.employee.EmployeeCrud.repository.IEmployeeRepository;
import com.employee.EmployeeCrud.service.IEmployeeService;

@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee deleteEmployee(int id) throws EmployeeNotFoundException {
		Optional<Employee> deletedEmployee = employeeRepository.findById(id);
		if (deletedEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			return deletedEmployee.get();
		} else {
			throw new EmployeeNotFoundException("Employee with id: " + id + " is not found");
		}
	}

	@Override
	public Employee viewById(int id) throws EmployeeNotFoundException {
		Optional<Employee> viewEmployee = employeeRepository.findById(id);
		if (viewEmployee.isPresent()) {
			return employeeRepository.findById(id).get();
		} else {
			throw new EmployeeNotFoundException("Employee with id: " + id + " is not found");
		}
	}

	@Override
	public List<Employee> viewEmployeeBySalaryAsc() {
		return employeeRepository.findByOrderBySalaryAsc();
	}

	@Override
	public List<Employee> viewEmployeeBySalarydesc() {
		return employeeRepository.findByOrderBySalaryDesc();
	}

}
