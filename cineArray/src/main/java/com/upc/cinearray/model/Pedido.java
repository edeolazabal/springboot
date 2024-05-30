package com.upc.cinearray.model;

public class Pedido {
    private Integer id;
    private Integer quantity;

    public Pedido(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
