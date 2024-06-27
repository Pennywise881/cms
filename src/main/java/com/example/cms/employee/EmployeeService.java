package com.example.cms.employee;

import com.example.cms.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDetailsRepository employeeDetailsRepository)
    {
        this.employeeRepository = employeeRepository;
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    public List<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }

    public void registerEmployee(Map<String, String> employeeInfo)
    {
//        System.out.println(employeeInfo);

        String phoneNumber = employeeInfo.get("phoneNumber");
        if (phoneNumber.length() != 10 || phoneNumber.matches(".*\\D.*"))
        {
            throw new IllegalStateException("Invalid phone number");
        }

        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByPhoneNumber("+880"+phoneNumber);
        if(employeeOptional.isPresent())
        {
            throw new IllegalStateException("Employee with this phone number already exists!");
        }

        int employeeTypeIndex;
        EmployeeType employeeType;
        try
        {
            employeeTypeIndex = Integer.parseInt(employeeInfo.get("employeeType"));
            employeeType = EmployeeType.values()[employeeTypeIndex];
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
        {
            throw new IllegalStateException("Invalid employee type");
        }

        System.out.println("I am here");

        Employee user = new Employee(
                employeeInfo.get("name"),
                employeeInfo.get("email"),
                LocalDate.parse(employeeInfo.get("dob")),
                employeeInfo.get("address"),
                "+880"+phoneNumber,
                employeeType);

        employeeRepository.save(user);

//        System.out.println("This was successful");
    }

    private EmployeeDTO getDTO(Employee employee, EmployeeDetails employeeDetails)
    {
        EmployeeType employeeType = EmployeeType.values()[employee.getEmployeeType()];

        return new EmployeeDTO(
                employee.getName(),
                employee.getEmail(),
                employee.getDob(),
                employee.getAddress(),
                employee.getPhoneNumber(),
                employeeType,
                employeeDetails.getDepartment().getName(),
                employeeDetails.isActive(),
                employeeDetails.isOnLeave(),
                employeeDetails.getSalary(),
                employeeDetails.getSickLeave(),
                employeeDetails.getCasualLeave()
        );
    }

    public EmployeeDTO getEmployeeInfo(Long employeeId)
    {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if(employeeOptional.isEmpty())
        {
            throw new IllegalStateException("No employee with exists with ID: "+employeeId);
        }

        Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsRepository.findDetailsByEmployeeId(employeeId);

        if(employeeDetailsOptional.isEmpty())
        {
            throw new IllegalStateException("Could not find details for employee with id:"+employeeId);
        }

        return getDTO(employeeOptional.get(), employeeDetailsOptional.get());
    }
}
