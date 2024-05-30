package com.upc.cine20241.model;

public class Tarifas {
    private Integer id;
    private String category;
    private Double price;

    // Constructores
    public Tarifas() {
    }

    public Tarifas(Integer id, String category, Double price) {
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
