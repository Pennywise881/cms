package com.example.cms.diagnosis;

import com.example.cms.inventory.Medicine;

import java.time.LocalDateTime;
import java.util.List;

public class DiagnosisDTO {

    private String patientId;
    private String patientName;
    private String patientContact;
    private String doctorId;
    private String doctorName;
    private String doctorContact;
    private String appointmentId;
    private LocalDateTime appointmentDateTime;
    private String details;
    private List<Medicine> medicineList;

    public DiagnosisDTO() {
    }

    public DiagnosisDTO(String patientId, String patientName, String patientContact, String doctorId, String doctorName, String doctorContact, String appointmentId, LocalDateTime appointmentDateTime, String details, List<Medicine> medicineList) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorContact = doctorContact;
        this.appointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.details = details;
        this.medicineList = medicineList;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorContact() {
        return doctorContact;
    }

    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}
