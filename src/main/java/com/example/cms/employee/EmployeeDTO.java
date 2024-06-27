package com.example.cms.employee;


import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDTO {
    private String name;
    private String email;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private EmployeeType employeeType;

    private String department;
    private boolean isActive, isOnLeave;
    private BigDecimal salary;
    private int sickLeave, casualLeave;

    public EmployeeDTO(String name, String email, LocalDate dob, String address, String phoneNumber, EmployeeType employeeType, String department, boolean isActive, boolean isOnLeave, BigDecimal salary, int sickLeave, int casualLeave) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.employeeType = employeeType;
        this.department = department;
        this.isActive = isActive;
        this.isOnLeave = isOnLeave;
        this.salary = salary;
        this.sickLeave = sickLeave;
        this.casualLeave = casualLeave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isOnLeave() {
        return isOnLeave;
    }

    public void setOnLeave(boolean onLeave) {
        isOnLeave = onLeave;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    public int getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(int casualLeave) {
        this.casualLeave = casualLeave;
    }
}
