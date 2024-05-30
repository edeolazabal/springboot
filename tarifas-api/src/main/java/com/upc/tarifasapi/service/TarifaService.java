package com.upc.tarifasapi.service;

import com.upc.tarifasapi.model.entity.Tarifa;
import com.upc.tarifasapi.repository.TarifaRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
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
    // Obtiene todas las tarifas
    public List<Tarifa> lista() { return tarifaRepository.findAll(); }

    public Integer precioMaximo() { return tarifaRepository.precioMaximo(); }

    // Inserta una tarifa
    public Tarifa inserta(Tarifa tarifa) { return tarifaRepository.save(tarifa); }

    public Tarifa modifica (Long id, Tarifa tarifa) throws Exception {
        // Pregunta si existe
        Tarifa tar = tarifaRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de tarifa no existe: "+ id));
        tar.setPrecio(tarifa.getPrecio());
        tar.setCategoria(tarifa.getCategoria());
        return tarifaRepository.save(tar);
    }
    public Tarifa elimina (Long id) throws Exception {
        // Pregunta si existe
        Tarifa tar = tarifaRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de tarifa no existe: "+ id));

        tarifaRepository.delete(tar);
        return tar;
    }


}
