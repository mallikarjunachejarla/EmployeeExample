package com.emp.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.example.model.Employee;
import com.emp.example.repository.EmployeeRepository;
import com.emp.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee e) {

		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String empId) {

		Employee emp = employeeRepository.findById(empId)
				.orElseThrow(() -> new RuntimeException("employee not found!!!!"));

		return emp;

	}

	@Override
	@Transactional
	public Employee updateEmploeeDetails(String id, Employee emp) {

		Employee e = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee not found!!!"));
		//e.setEmpId(emp.getEmpId());
		e.setDateOfJoining(emp.getDateOfJoining());
		e.setDepartment(emp.getDepartment());
		e.setEmpName(emp.getEmpName());
		e.setLocation(emp.getLocation());
		e.setSalary(emp.getSalary());

		return employeeRepository.save(e);
	}

	@Override
	public void deleteEmployeeById(String empId) {
		Employee ee = employeeRepository.findById(empId)
				.orElseThrow(() -> new RuntimeException("employee not found!!!"));

		employeeRepository.delete(ee);

	}
}
