package com.upc.cinebdapi.service;

import com.upc.cinebdapi.model.Compra;
import com.upc.cinebdapi.model.Listado;
import com.upc.cinebdapi.model.Tarifa;
import com.upc.cinebdapi.repository.CompraRepository;
import com.upc.cinebdapi.repository.TarifaRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListadoService {
    @Autowired
    private final CompraRepository compraRepository;

    @Autowired
    private final TarifaRepository tarifaRepository;

    public ListadoService(CompraRepository compraRepository, TarifaRepository tarifaRepository) {
        this.compraRepository = compraRepository;
        this.tarifaRepository = tarifaRepository;
    }
    public List<Listado> lista() {
        List<Compra> compras = compraRepository.findAll();
        List<Listado> listado = new ArrayList<Listado>();
        Listado elem;
        for (Compra c: compras) {
            elem = new Listado();
            // Obtener datos de la salida
            elem.setFecha(c.getFecha());
            elem.setCategoria(c.getTarifa().getCategoria());
            elem.setCantidad(c.getCantidad());
            // Calcular importe en soles
            elem.setImporte(c.getTarifa().getPrecio() * c.getCantidad());
            // Agrega a la lista
            listado.add(elem);
            elem = null;
        }
        return listado;
    }
}
