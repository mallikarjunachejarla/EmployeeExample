package com.emp.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.emp.example.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
