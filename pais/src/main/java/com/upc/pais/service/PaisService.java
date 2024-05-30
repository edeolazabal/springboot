package com.upc.pais.service;

import com.upc.pais.dto.PaisDTO;
import com.upc.pais.entity.Pais;
import com.upc.pais.repository.PaisRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Observable;
import java.util.Optional;

@Service
public class PaisService {
    final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }
    public List<Pais> list () { return paisRepository.findAll(); }
    public Pais listById (Long id)  { return paisRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Not found country with id="+id)); }
    public Pais insert (Pais pais) {return paisRepository.save(pais);}

    public Pais update (Long id, Pais pais) {
        Pais p = paisRepository.findById(id).orElseThrow();
        if (p == null) throw new RuntimeException("Not found country with id="+id);
        p.setNombre(pais.getNombre());
        p.setCapital(pais.getCapital());

        return paisRepository.save(p); }

    public Pais delete (Long id) {
        Pais p = paisRepository.findById(id).orElseThrow();
        if (p == null) throw new RuntimeException("Not found country with id="+id);
        paisRepository.delete(p);

        return p;
    }

}
