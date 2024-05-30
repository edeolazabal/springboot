package com.upc.entradascineapi.model;

public class Tarifa {
    private Integer id;
    private String categoria;
    private double precio;

    public Tarifa() {
    }

    public Tarifa(Integer id, String categoria, double precio) {
        this.id = id;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
