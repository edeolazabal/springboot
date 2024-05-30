package com.upc.cinebdapi.service;

import com.upc.cinebdapi.model.Tarifa;
import com.upc.cinebdapi.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaService {
    @Autowired
    private final TarifaRepository tarifaRepository;

    public TarifaService(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }
    public List<Tarifa> lista () {
        return tarifaRepository.findAll();
    }
    public Tarifa inserta (Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }
}
