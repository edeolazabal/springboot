package com.example.demoapi.model;

import java.util.Date;

public class Categoria {
    private int id;
    private String descripcion;

    private Date fecha = new Date();

    public Categoria(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = new Date();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    
}
