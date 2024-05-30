package com.upc.alumnoapi.model;

public interface IBoletaCine {
    String fechaHora = null;
    Integer Cantidad = null;
    String Categoria = null;
    Double ImporteTotal = null;
    //Getters
    String getFechaHora();
    Integer getCantidad();
    String getCategoria();
    Double getImporteTotal();

}
