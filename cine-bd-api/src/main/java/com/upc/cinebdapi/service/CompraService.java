package com.upc.cinebdapi.service;

import com.upc.cinebdapi.model.Compra;
import com.upc.cinebdapi.model.CompraDto;
import com.upc.cinebdapi.model.Tarifa;
import com.upc.cinebdapi.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    private final CompraRepository compraRepository;

    public CompraService (CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }
    public List<Compra> lista() {
        return compraRepository.findAll();
    }
    public List<CompraDto> listaDto() {
        List<CompraDto> listaSalida = new ArrayList<>();
        List<Compra> lista = compraRepository.findAll();
        CompraDto compraDto = new CompraDto();
        for (Compra c: lista) {
            compraDto.setCantidad(c.getCantidad());
            compraDto.setId_Tarifa(0L);
            if (c.getTarifa().getId() != null)    compraDto.setId_Tarifa(c.getTarifa().getId());
            listaSalida.add(compraDto);
        }
        return listaSalida;
    }
    public Compra inserta (Compra compra) {
        return compraRepository.save(compra);
    }
    public Compra insertaDto (CompraDto compraDto) {
        Compra compra = new Compra();
        Tarifa tarifa = new Tarifa();

        tarifa.setId(compraDto.getId_Tarifa());
        compra.setCantidad(compraDto.getCantidad());

        compra.setTarifa(tarifa);
        return compraRepository.save(compra);
    }
    public String insertaCompraDto (CompraDto compraDto) {

        compraRepository.insertCompraDto(compraDto.getCantidad(), compraDto.getId_Tarifa());
        return "OK";
    }

}
