package com.example.demojphibernate01.controller;

import com.example.demojphibernate01.entity.Employee;
import com.example.demojphibernate01.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/insert")
    public Employee insertEmployee() {
        Employee employee = new Employee();
		employee.setFirstName("Vann");
		employee.setLastName("Krya");
		employee.setEmail("krya.vann@gmail.com");
		employee.setBirthDate(new Date());
        employee.setTemp("temp field...!");
        return employeeRepository.insertEmployee(employee);
    }

    @GetMapping("/find-by-id/{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @DeleteMapping("/remove-by-id/{id}")
    public void removeEmployeeById(@PathVariable Long id) {
         employeeRepository.removeEmployeeById(id);
    }

    @PostMapping("/detach-state")
    public Employee detachState() {
        Employee employee = new Employee();
        employee.setFirstName("detach firstname");
        employee.setLastName("detach lastname");
        employee.setEmail("detach@gmail.com");
        employee.setBirthDate(new Date());
        employee.setTemp("temp field...!");
        return employeeRepository.detachState(employee);
    }
}
