package com.learnspring.week2.controllers;

import com.learnspring.week2.dto.EmployeeDTO;
import com.learnspring.week2.entities.EmployeeEntity;
import com.learnspring.week2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }
}
