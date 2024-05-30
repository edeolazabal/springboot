package com.upc.entradascineapi.model;

public class Pedido {
    private Integer id_categoria;
    private Integer cantidad;

    public Pedido() {
    }

    public Pedido(Integer id_categoria, Integer cantidad) {
        this.id_categoria = id_categoria;
        this.cantidad = cantidad;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
