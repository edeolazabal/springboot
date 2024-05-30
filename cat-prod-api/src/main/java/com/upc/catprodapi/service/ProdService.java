package com.upc.catprodapi.service;

import com.upc.catprodapi.model.Cat;
import com.upc.catprodapi.model.Prod;
import com.upc.catprodapi.repository.CatRepository;
import com.upc.catprodapi.repository.ProdRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdService {
    @Autowired
    private final ProdRepository prodRepository;

    public ProdService (ProdRepository prodRepository) {
        this.prodRepository = prodRepository;
    }
    public List<Prod> lista () { return prodRepository.findAll();}

    public Prod inserta (Prod prod) { return prodRepository.save(prod);}

    public Prod obtieneUnaCat(Long id) {
        return prodRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID =" + id));
    }
}
