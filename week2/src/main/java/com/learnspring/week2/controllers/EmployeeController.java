package com.learnspring.week2.controllers;

import com.learnspring.week2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id) {
        return new EmployeeDTO(id, "Anuj", "anuj@gmail.com", 27, LocalDate.of(2024, 1, 2), true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "Hi Age"+ age + sortBy;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(100L);
        return inputEmployee;
    }
}
