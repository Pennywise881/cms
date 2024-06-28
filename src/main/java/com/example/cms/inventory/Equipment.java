package com.example.cms.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Table
@Entity
public class Equipment extends Inventory{
    private String manufacturer;
    private String supplier;
    private String warranty;

    public Equipment() {
    }

    public Equipment(String name, int quantity, BigDecimal buyingPrice, InventoryType inventoryType, String manufacturer, String supplier, String warranty) {
        super(name, quantity, buyingPrice, inventoryType);
        this.manufacturer = manufacturer;
        this.supplier = supplier;
        this.warranty = warranty;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}
