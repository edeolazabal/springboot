package com.upc.cinearray.model;

import java.util.Date;

public class Compras {
    private Integer quantity;
    private String category;
    private double amount;
    private Date created = new Date();

    public Compras(Integer quantity, String category, double amount) {
        this.quantity = quantity;
        this.category = category;
        this.amount = amount;
    }

    public Compras() {
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
