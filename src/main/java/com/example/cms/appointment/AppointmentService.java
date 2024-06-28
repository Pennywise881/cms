package com.example.cms.appointment;

import com.example.cms.employee.Employee;
import com.example.cms.employee.EmployeeDetails;
import com.example.cms.employee.EmployeeRepository;
import com.example.cms.patient.Patient;
import com.example.cms.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, EmployeeRepository employeeRepository)
    {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.employeeRepository = employeeRepository;
    }

    private AppointmentDTO convertToDTO(Patient patient, Employee doctor, LocalDateTime appointmentTime)
    {
        EmployeeDetails doctorDetails = doctor.getEmployeeDetails();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, d, MMMM, yyyy, hh:mm a");

        return new AppointmentDTO(
                patient.getId(),
                patient.getName(),
                patient.getPhoneNumber(),
                doctor.getId(),
                doctor.getName(),
                doctor.getPhoneNumber(),
                doctorDetails.getDepartment().getName(),
                dateTimeFormatter.format(appointmentTime)
        );
    }

    public List<AppointmentDTO> getAllAppointments()
    {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();

        for (Appointment appointment:appointments)
        {
            appointmentDTOList.add(
                    convertToDTO(
                            appointment.getPatient(),
                            appointment.getDoctor(),
                            appointment.getAppointmentDateTime()
                    )
            );
        }

        return appointmentDTOList;
    }
}
