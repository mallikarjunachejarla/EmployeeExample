package com.emp.example.controller;

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

import com.emp.example.model.Employee;
import com.emp.example.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee emp) {

		try {

			return new ResponseEntity<>(employeeService.createEmployee(emp), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
		try {

			return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable String id) {

		try {
			return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee emp) {

		try {
			return new ResponseEntity<>(employeeService.updateEmploeeDetails(id, emp), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {

		try {
			employeeService.deleteEmployeeById(id);
			return ResponseEntity.ok("deleted successfully!!!!");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!!!!!!!");

		}

	}

}
