package com.upc.demosec.service;

import com.upc.demosec.model.Ciudad;
import com.upc.demosec.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<Ciudad> listAll() { return ciudadRepository.findAll(); }

    public Ciudad insert(Ciudad ciudad) {return ciudadRepository.save(ciudad); }
}
