package com.upc.contactosjwt.service;

import com.upc.contactosjwt.model.Contacto;
import com.upc.contactosjwt.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {
    @Autowired
    ContactoRepository contactoRepository;
    public List<Contacto> listar() { return contactoRepository.findAll();  }

    public Contacto crear(Contacto nuevoContacto) { return contactoRepository.save(nuevoContacto); }
}
