package com.emp.example.service;

import java.util.List;

import com.emp.example.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee e);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String empId);

	Employee updateEmploeeDetails(String id, Employee emp);

	void deleteEmployeeById(String empId);

}
