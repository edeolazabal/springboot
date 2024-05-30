package com.upc.entradascineapi.model;

import java.util.Date;

public class Compra {
    private Date fecha = new Date();
    private Integer cantidad;
    private String categoria;
    private double importe;

    public Compra() {
    }

    public Compra(Integer cantidad, String categoria, double importe) {
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
