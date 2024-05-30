package com.upc.cine20241.model;

import java.util.Date;

public class Compras {
    private Integer quantity;
    private String category;
    private double amount;
    private Date created = new Date();
    private double montoIGV;
    private double importeConIGV;

    public double getMontoIGV() {
        return montoIGV;
    }

    public void setMontoIGV(double montoIGV) {
        this.montoIGV = montoIGV;
    }

    public double getImporteConIGV() {
        return importeConIGV;
    }

    public void setImporteConIGV(double importeConIGV) {
        this.importeConIGV = importeConIGV;
    }

    public Compras() {
    }

    public Compras(Integer quantity, String category, double amount, Date created) {
        this.quantity = quantity;
        this.category = category;
        this.amount = amount;
        this.created = created;
    }

    public Compras(Integer quantity, String category, double amount, Date created, double montoIGV, double importeConIGV) {
        this.quantity = quantity;
        this.category = category;
        this.amount = amount;
        this.created = created;
        this.montoIGV = montoIGV;
        this.importeConIGV = importeConIGV;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
