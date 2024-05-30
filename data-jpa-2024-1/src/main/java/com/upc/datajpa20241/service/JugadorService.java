package com.upc.datajpa20241.service;

import com.upc.datajpa20241.dto.CuentaJugadorDto;
import com.upc.datajpa20241.repository.JugadorRepository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {
    final JugadorRepository jugadorRepository;
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public String obtieneNombre(Integer id) {
        return jugadorRepository.obtieneNombre(id);
    }
    public CuentaJugadorDto obtieneNombre2(Integer id) {
        CuentaJugadorDto cuenta = new CuentaJugadorDto();  // crear un objeto para transferencia de datos
        Tuple t = jugadorRepository.obtieneNombre2(id);    // obtiene la tupla generada por el repositorio
        cuenta.setDenominacion(t.get("denominacion", String.class));  // asigna valor a la propiedad Denominación a partir de la tupla
        cuenta.setCantidad(t.get("cantidad", Long.class)); // asigna valor a la propiedad Cantidad a partir de la tupla
        return cuenta;  // retorna un dto
    }

}
