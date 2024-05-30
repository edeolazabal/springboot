package com.upc.autoapi.service;
import com.upc.autoapi.dto.AutoDto;
import com.upc.autoapi.model.Auto;
import com.upc.autoapi.repository.AutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    private final AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }
    public List<Auto> GetAll () {
        return autoRepository.findAll();
    }
    public Auto GetById (int id) {
        return autoRepository.findById(id).orElse(null);
    }
    public Auto Add (AutoDto autoDto) {
        Auto auto = new Auto(autoDto.getBrand(), autoDto.getPrice());
        return autoRepository.save(auto);
    }
}
