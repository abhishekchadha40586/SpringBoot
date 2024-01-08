package com.example.restcrud.service;

import com.example.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);
    void delete(int id);
}
