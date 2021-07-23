package com.employee.EmployeeCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeCrud.dto.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer>{
	List<Employee> findByOrderBySalaryAsc();
	List<Employee> findByOrderBySalaryDesc();

}
