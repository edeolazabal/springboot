package com.com.jwtdemo.service;

import com.com.jwtdemo.model.Pais;
import com.com.jwtdemo.model.PaisDTO;
import com.com.jwtdemo.repository.PaisRepository;
import jakarta.persistence.Tuple;
import org.hibernate.annotations.NotFound;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaisService {
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> lista() {
        return paisRepository.findAll();
    }
    public Pais inserta (Pais pais) {
        return paisRepository.save(pais);
    }
    public Pais listaPorId(Integer id) {
        return paisRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id not found: "+ id));
    }
    public List<PaisDTO> listaNombreOrdenado() {
        List<Tuple> lista = paisRepository.listaNombreOrdenado();
        List<PaisDTO> listaPais = new ArrayList<>();
        PaisDTO elem;
        for (Tuple p : lista) {
            elem = new PaisDTO();
            // Agregado 2023-09-22
            elem.setName("");
            if (p.get(0) != null) elem.setName(p.get(0).toString());
            ///------------------
            listaPais.add(elem);
            elem = null;
        }
        return listaPais;
    }
    public List<Pais> findByName(String name) {
        return paisRepository.findByName(name);
    }
    public List<Pais> listaPorNombre (String name) {
        return paisRepository.listaPorNombre(name);
    }
}
