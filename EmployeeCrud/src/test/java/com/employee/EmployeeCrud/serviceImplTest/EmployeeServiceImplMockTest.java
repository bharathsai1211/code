package com.employee.EmployeeCrud.serviceImplTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.EmployeeCrud.dto.Employee;
import com.employee.EmployeeCrud.exception.EmployeeNotFoundException;
import com.employee.EmployeeCrud.repository.IEmployeeRepository;
import com.employee.EmployeeCrud.serviceimpl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplMockTest {
	@Mock
	IEmployeeRepository employeeRepository;
	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Test
	void addEmployee() {
		Employee employee = mock(Employee.class);
		employeeService.addEmployee(employee);
		verify(employeeRepository).save(employee);
	}

	@Test
	void updateEmployee() {
		Employee employee = mock(Employee.class);
		employeeService.updateEmployee(employee);
		verify(employeeRepository).save(employee);
	}
	@Test
	void deleteEmployee() throws EmployeeNotFoundException
	{
		Employee employee =new Employee();
		int id=1;
		employee.setId(1);
		employeeService.addEmployee(employee);
		Executable executable=()->{
			employeeService.deleteEmployee(employee.getId());
		};
		verify(employeeRepository).deleteById(employee.getId());
		Assertions.assertThrows(EmployeeNotFoundException.class, executable);
		
	}
	@Test
	void viewEmployee() throws EmployeeNotFoundException
	{
		int id=1;
		Employee employee=mock(Employee.class);
		//employeeService.viewById(id);
		Optional<Employee> optional=Optional.of(employee);
		when(employeeRepository.findById(id)).thenReturn(optional);
		verify(employeeRepository).findById(id);
		
	}
}
