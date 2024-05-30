package com.upc.tarifasapi.service;

import com.upc.tarifasapi.model.entity.Compra;
import com.upc.tarifasapi.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {
    @Autowired
    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }
    // Obtiene todos los registros
    public List<Compra> lista() { return compraRepository.findAll(); }
    // Inserta un registro
    public  Compra inserta (Compra compra) { return compraRepository.save(compra); }
}
