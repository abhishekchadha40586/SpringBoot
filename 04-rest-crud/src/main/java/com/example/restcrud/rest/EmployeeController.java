package com.example.restcrud.rest;

import com.example.restcrud.dao.EmployeeDAO;
import com.example.restcrud.entity.Employee;
import com.example.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        List<Employee> employees =employeeService.findAll();
        return employees;
    }

    @GetMapping("/employee/{employeeid}")
    public Employee getEmployeeById(@PathVariable int employeeid){
        Employee employee=employeeService.findById(employeeid);
        return employee;
    }

//    add new employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee reqEmployee){
        // in case id is sent, assign it to 0 so that merge treats it as a new object to save instead of update
        reqEmployee.setId(0);
        return employeeService.save(reqEmployee);
    }

    @PutMapping("/employee")
    public Employee editEmployee(@RequestBody Employee reqEmployee){
        return employeeService.save(reqEmployee);
    }

    @DeleteMapping("/employee/{employeeid}")
    public void deleteEmployee(@PathVariable int employeeid){
        employeeService.delete(employeeid);
    }
}
