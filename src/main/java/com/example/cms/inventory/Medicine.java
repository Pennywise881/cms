package com.example.cms.inventory;

import com.example.cms.diagnosis.Diagnosis;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Medicine extends Inventory {

    private String brand;
    private String dosage;
    private String batchCode;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private String supplier;
    private String supplierPhoneNumber;

    @ManyToOne()
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    public Medicine()
    {

    }

    public Medicine(String name, int quantity, BigDecimal buyingPrice, InventoryType inventoryType, String brand, String dosage, String batchCode, LocalDate manufacturingDate, LocalDate expirationDate, String supplier, String supplierPhoneNumber)
    {
        super(name, quantity, buyingPrice, inventoryType);
        this.brand=brand;
        this.dosage=dosage;
        this.batchCode=batchCode;
        this.manufacturingDate=manufacturingDate;
        this.expirationDate=expirationDate;
        this.supplier=supplier;
        this.supplierPhoneNumber=supplierPhoneNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }
}
