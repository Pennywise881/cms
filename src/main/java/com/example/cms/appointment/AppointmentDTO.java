package com.example.cms.appointment;

public class AppointmentDTO {

    private Long patientId;
    private String patientName;
    private String patientContact;
    private Long doctorId;
    private String doctorName;
    private String doctorContact;
    private String doctorDepartment;
    private String appointmentTime;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long patientId, String patientName, String patientContact, Long doctorId, String doctorName, String doctorContact, String doctorDepartment, String appointmentTime) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorContact = doctorContact;
        this.doctorDepartment = doctorDepartment;
        this.appointmentTime = appointmentTime;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
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

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
