package com.upc.cine20241.model;

public class DatosIGV {
    private Double montoIGV;
    private Double totalConGV;

    public DatosIGV(Double montoIGV, Double totalConGV) {
        this.montoIGV = montoIGV;
        this.totalConGV = totalConGV;
    }

    public DatosIGV() {
    }

    public Double getMontoIGV() {
        return montoIGV;
    }

    public Double getTotalConGV() {
        return totalConGV;
    }

    public void setMontoIGV(Double montoIGV) {
        this.montoIGV = montoIGV;
    }

    public void setTotalConGV(Double totalConGV) {
        this.totalConGV = totalConGV;
    }
}
