package com.example.cms.employee;

import com.example.cms.department.Department;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class EmployeeDetails {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name="department_id")
    private Department department;

    private boolean isActive, isOnLeave;
    private BigDecimal salary;
    private int sickLeave, casualLeave;

    public EmployeeDetails() {
    }

    public EmployeeDetails(Employee employee, Department department, boolean isActive, boolean isOnLeave, BigDecimal salary) {
        this.employee = employee;
        this.department = department;
        this.isActive = isActive;
        this.isOnLeave = isOnLeave;
        this.salary = salary;
        this.sickLeave = 10;
        this.casualLeave = 15;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
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
