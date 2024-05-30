package com.upc.catprodapi.service;

import com.upc.catprodapi.model.Cat;
import com.upc.catprodapi.repository.CatRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    @Autowired
    private final CatRepository catRepository;

    public CatService (CatRepository catRepository) {
        this.catRepository = catRepository;
    }
    public List<Cat> lista () { return catRepository.findAll();}

    public Cat inserta (Cat cat) { return catRepository.save(cat);}

    public Cat obtieneUnaCat(Long id) {
        return catRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID =" + id));
    }
}
