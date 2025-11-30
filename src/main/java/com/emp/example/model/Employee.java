package com.emp.example.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
	@Id
	private String empId;
	private String empName;
	private String department;
	private String location;
	private Long salary;
	private LocalDate dateOfJoining;

}
