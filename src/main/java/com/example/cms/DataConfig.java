package com.example.cms;

import com.example.cms.department.Department;
import com.example.cms.department.DepartmentRepository;
import com.example.cms.employee.*;
import com.example.cms.inventory.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            MedicineRepository medicineRepository)
    {
        return args ->
        {
            Department dep1 = new Department("Internal Medicine");
            Department dep2 = new Department("Dermatology");
            Department dep3 = new Department("Facilities");
            Department dep4 = new Department("Physical Therapy");
            Department dep5 = new Department("Pharmacy");
            Department dep6 = new Department("Human Resources");
            Department dep7 = new Department("Administration");
            departmentRepository.saveAll(List.of(dep1,dep2,dep3,dep4,dep5,dep6,dep7));

            Employee nafi = new Employee(
                    "Nafi Uz Zaman",
                    "zamannafi3@gmail.com",
                    LocalDate.of(1992, Month.JANUARY, 10),
                    "Road 07, House 34, SKS Tower, Mohakhali, Dhaka, 1288",
                    "+8801977423491",
                    EmployeeType.DOCTOR
            );
            employeeRepository.saveAll(List.of(nafi));

            EmployeeDetails nafiDetails = new EmployeeDetails(
                    nafi,
                    dep1,
                    true,
                    false,
                    BigDecimal.valueOf(50000.0)
            );

            nafi.setEmployeeDetails(nafiDetails);
            employeeRepository.save(nafi);

            Medicine medicine = new Medicine(
                    "Paracetamol",
                    10,
                    BigDecimal.valueOf(1000.0),
                    InventoryType.MEDICINE,
                    "Tylenol",
                    "500mg",
                    "B10992",
                    LocalDate.of(2024, Month.JANUARY, 1),
                    LocalDate.of(2025, Month.DECEMBER, 31),
                    "Beximco",
                    "+8801954765412"
            );
            
            medicineRepository.saveAll(List.of(medicine));
        };
    }
}
