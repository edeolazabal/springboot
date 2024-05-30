package com.upc.catbd2api.model;

public class CategoriaProductoDTO {
    Long id;
    String descripcion;
    Long total;

    public CategoriaProductoDTO(Long id, String descripcion, Long total) {
        this.id = id;
        this.descripcion = descripcion;
        this.total = total;
    }

    public CategoriaProductoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
