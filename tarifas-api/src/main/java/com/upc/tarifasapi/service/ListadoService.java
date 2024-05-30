package com.upc.tarifasapi.service;

import com.upc.tarifasapi.dto.ListadoDescuento;
import com.upc.tarifasapi.dto.ListadoIgv;
import com.upc.tarifasapi.dto.SoloCategoriaDTO;
import com.upc.tarifasapi.model.entity.Compra;
import com.upc.tarifasapi.dto.Listado;
import com.upc.tarifasapi.model.entity.Tarifa;
import com.upc.tarifasapi.repository.CompraRepository;
import com.upc.tarifasapi.repository.TarifaRepository;
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
        // Recorre un arreglo de compras
        for (Compra c: compras) {
            // Construir una fila de listado
            elem = new Listado();
            elem.setFecha(c.getFecha());
            elem.setCategoria(c.getTarifa().getCategoria());
            elem.setCantidad(c.getCantidad());
            elem.setImporte(c.getCantidad() * c.getTarifa().getPrecio());
            // agregar a un arreglo de listado
            listado.add(elem);
            elem = null;
        }
        // Devolver el listado creado
        return listado;

    }
    public List<ListadoIgv> listaIgv() {
        List<Compra> compras = compraRepository.findAll();  // Obtener todas las compras
        List<ListadoIgv> listado = new ArrayList<ListadoIgv>();         // crear un arreglo para el lista
        ListadoIgv elem;                                       // crear elemento para construir el listado
        // Recorrer las compras
        for (Compra c: compras) {
            // Construir una fila de listado
            elem = new ListadoIgv();
            elem.setFecha(c.getFecha());
            elem.setCategoria(c.getTarifa().getCategoria());
            elem.setCantidad(c.getCantidad());
            elem.setImporte(c.getCantidad() * c.getTarifa().getPrecio());
            elem.setIgv(c.getCantidad() * c.getTarifa().getPrecio() * 0.18);
            elem.setImporte_con_igv(elem.getImporte() + elem.getIgv());
            // agregar a un arreglo de listado
            listado.add(elem);
            elem = null;
        }
        // Devolver el listado con IGV creado
        return listado;
    }
    public List<ListadoDescuento> listaDescuento() {
        List<Compra> compras = compraRepository.findAll();  // Obtener todas las compras
        List<ListadoDescuento> listado = new ArrayList<ListadoDescuento>();         // crear un arreglo para el lista
        ListadoDescuento elem;                                       // crear elemento para construir el listado
        // Recorrer las compras
        for (Compra c: compras) {
            // Construir una fila de listado
            elem = new ListadoDescuento();
            elem.setFecha(c.getFecha());
            elem.setCategoria(c.getTarifa().getCategoria());
            elem.setCantidad(c.getCantidad());
            elem.setImporte(c.getCantidad() * c.getTarifa().getPrecio());
            elem.setIgv(c.getCantidad() * c.getTarifa().getPrecio() * 0.18);
            elem.setImporte_con_igv(elem.getImporte() + elem.getIgv());
            // Ejercicio 3
            elem.setDescuento(0);
            if (c.getCantidad() > 10) elem.setDescuento(.10 * elem.getImporte_con_igv()); // Aplicar descuento
            elem.setImporte_con_descuento(elem.getImporte_con_igv()- elem.getDescuento());

            // agregar a un arreglo de listado
            listado.add(elem);
            elem = null;
        }
        // Devolver el listado con IGV creado
        return listado;
    }
    public List<SoloCategoriaDTO> listaSoloCategoria() {
        // Leer todos los registros
        List<Tarifa> tarifas = tarifaRepository.findAll();
        // Crear Lista SoloCategoriaDTO
        List<SoloCategoriaDTO> soloCategoriaDTOS = new ArrayList<>();
        SoloCategoriaDTO elem;
        // por cada registro
        for (Tarifa tarifa : tarifas)
        {
            // Crear instancia de SoloCategoria
            elem = new SoloCategoriaDTO();
            // Mapear de Categoria a SoloCategoria
            elem.setCategoria(tarifa.getCategoria());
            // Agragar a la lista
            soloCategoriaDTOS.add(elem);
            elem = null;
        }

        // devolver lista SoloCatetegoriaDTO
        return soloCategoriaDTOS;
    }
}
