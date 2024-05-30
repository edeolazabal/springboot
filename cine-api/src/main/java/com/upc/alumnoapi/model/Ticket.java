package com.upc.alumnoapi.model;


public interface Ticket {
    String fechaHora = null;
    Integer cantidad = null;
    String categoria = null;
    Double importeTotal = null;
    Double igv = null;
    Double imponibleBase = null;
    // Getter;
    String getFechaHora();
    Integer getCantidad();
    String getCategoria();
    Double getImporteTotal();
    double getIgv();
    double getImponibleBase();

}
