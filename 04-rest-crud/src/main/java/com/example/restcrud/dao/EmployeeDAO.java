package com.example.restcrud.dao;

import com.example.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);
    Employee save( Employee employee);

    void delete(int id);
}
