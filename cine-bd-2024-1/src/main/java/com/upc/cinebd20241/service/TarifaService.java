package com.upc.cinebd20241.service;

import com.upc.cinebd20241.model.Tarifa;
import com.upc.cinebd20241.repository.TarifaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaService {
    final TarifaRepository tarifaRepository;

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
