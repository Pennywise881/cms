package com.example.cms;

import com.example.cms.appointment.Appointment;
import com.example.cms.appointment.AppointmentRepository;
import com.example.cms.department.Department;
import com.example.cms.department.DepartmentRepository;
import com.example.cms.diagnosis.Diagnosis;
import com.example.cms.diagnosis.DiagnosisRepository;
import com.example.cms.employee.*;
import com.example.cms.inventory.*;
import com.example.cms.patient.Patient;
import com.example.cms.patient.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            InventoryRepository inventoryRepository,
            PatientRepository patientRepository,
            AppointmentRepository appointmentRepository,
            DiagnosisRepository diagnosisRepository)
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

            Supplies supplies = new Supplies(
                    "Gloves",
                    200,
                    BigDecimal.valueOf(650),
                    InventoryType.SUPPLIES,
                    "Medical Supplies Inc.",
                    "Disposable gloves"
            );

            Equipment equipment = new Equipment(
                    "X-Ray Machine",
                    1,
                    BigDecimal.valueOf(100000.0),
                    InventoryType.EQUIPMENT,
                    "MedTech",
                    "Health Inc.",
                    "10 years"
            );
            
            inventoryRepository.saveAll(List.of(medicine, supplies, equipment));

            Patient patient = new Patient(
                    "Beefy Pupee",
                    "+88018739983"
            );

            Patient patient1 = new Patient(
                    "Mr. Dola",
                    "+8801912245678"
            );

            patientRepository.saveAll(List.of(patient, patient1));

            Appointment appointment = new Appointment(
                   patient,
                   nafi,
                   LocalDateTime.now()
            );

            Appointment appointment1 = new Appointment(
                    patient,
                    nafi,
                    LocalDateTime.of(2024, Month.JULY, 7, 8, 42)
            );

            Appointment appointment2 = new Appointment(
                    patient1,
                    nafi,
                    LocalDateTime.of(2024, Month.JULY, 7, 10, 0)
            );

            appointmentRepository.saveAll(List.of(
                    appointment,
                    appointment1,
                    appointment2
                    )
            );

            Diagnosis diagnosis = new Diagnosis(
                    patient,
                    nafi,
                    appointment.getId(),
                    "Patient has a severe headache therefore, prescribing paracetamol",
                    List.of(medicine)
            );

            diagnosisRepository.save(diagnosis);

            medicine.setQuantity(medicine.getQuantity()-1);
            inventoryRepository.save(medicine);
        };
    }
}
