package com.example.cms.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @PostMapping(path = "/register-employee")
    public void registerUser(@RequestBody Map<String, String> payload)
    {
        employeeService.registerEmployee(payload);
    }

    @GetMapping(path = "/info/{employeeId}")
    public EmployeeDTO getEmployeeInfo(@PathVariable("employeeId") Long id)
    {
        return employeeService.getEmployeeInfo(id);
    }
}
