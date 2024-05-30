package com.upc.cine20241.service;

import com.upc.cine20241.model.DatosIGV;
import org.springframework.stereotype.Service;

@Service
public class CineService {
// regla de ngocio
    double  IGV = 0.18;
    public DatosIGV calculaImportes (Double price, double quantity) {
        DatosIGV datos = new DatosIGV();
        datos.setMontoIGV( price * quantity * IGV);
        datos.setTotalConGV((price * quantity) * (1 + IGV));
        if (quantity > 20) datos.setTotalConGV((price * quantity) * (1 + IGV) * (1 - 0.10));
        return datos;
    }
}
