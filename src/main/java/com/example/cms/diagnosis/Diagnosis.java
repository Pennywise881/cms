package com.example.cms.diagnosis;


import com.example.cms.appointment.Appointment;
import com.example.cms.employee.Employee;
import com.example.cms.inventory.Medicine;
import com.example.cms.patient.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnore
    private Employee doctor;

//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "id")
//    private Appointment appointment;
    private Long appointmentId;

    private String details;

    @OneToMany(mappedBy = "diagnosis", orphanRemoval = false)
    private List<Medicine> medicineList;

    public Diagnosis() {
    }

    public Diagnosis(Patient patient, Employee doctor, /*Appointment appointment*/Long appointmentId, String details, List<Medicine> medicineList) {
        this.patient = patient;
        this.doctor = doctor;
//        this.appointment = appointment;
        this.appointmentId = appointmentId;
        this.details = details;
        this.medicineList = medicineList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

//    public Appointment getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(Appointment appointment) {
//        this.appointment = appointment;
//    }
//
    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
