package com.example.restcrud.dao;

import com.example.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// basic CRUD methods provided for free just pass in class name and primary key type
// Now instead of /employees path will be /members
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
