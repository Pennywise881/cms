package com.example.cms.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table
public class Supplies extends Inventory{
    private String supplier;
    private String description;

    public Supplies() {
    }

    public Supplies(String name, int quantity, BigDecimal buyingPrice, InventoryType inventoryType, String supplier, String description) {
        super(name, quantity, buyingPrice, inventoryType);
        this.supplier = supplier;
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
