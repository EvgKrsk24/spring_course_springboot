package com.zaurtregulov.spring.springboot.springboot_rest.controller;


import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import com.zaurtregulov.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees=employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) { //принимаем запрос POST(тело метода в виде JSON 'исп dep Jacson') при помощи @RequestBody с методом контроллера @PostMapping("/employees")

        employeeService.saveEmployee(employee);
        return employee;

    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }



}
