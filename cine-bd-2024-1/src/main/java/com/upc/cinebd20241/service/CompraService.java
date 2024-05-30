package com.upc.cinebd20241.service;

import com.upc.cinebd20241.dto.Listado;
import com.upc.cinebd20241.dto.Pedido;
import com.upc.cinebd20241.model.Compra;
import com.upc.cinebd20241.model.Tarifa;
import com.upc.cinebd20241.repository.CompraReposititory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {
    final CompraReposititory compraReposititory;

    public CompraService(CompraReposititory compraReposititory) {
        this.compraReposititory = compraReposititory;
    }
    public List<Compra> lista() {
        return compraReposititory.findAll();
    }
    public Compra inserta (Pedido pedido) {
        Compra compra = new Compra();
        Tarifa tarifa = new Tarifa();

        compra.setCantidad(pedido.getCantidad());
        tarifa.setId(pedido.getId_tarifa());

        compra.setTarifa(tarifa);
         return compraReposititory.save(compra);
    }
    public List<Listado> listaCompras() {
        List<Compra> compras = compraReposititory.findAll();
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
