package com.upc.pruebabrenda.model;

public class Pedido {
    Integer id;
    Integer cantidad;

    public Pedido(Integer id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
