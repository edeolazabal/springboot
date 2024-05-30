package com.com.clientecrud.service;

import com.com.clientecrud.model.Cliente;
import com.com.clientecrud.repository.ClienteRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos Clientes
    @Transactional (readOnly = true)
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener por Id
    @Transactional (readOnly = true)
    public Cliente getCliente(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID = " + clienteId));
    }

    // Insertar Cliente
    @Transactional
    public Cliente insertCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Modificar Cliente
    @Transactional
    public Cliente updateCliente(Long clienteId,
                                 Cliente clienteDetalle) {
        // Verifica que el Id exista
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID = " + clienteId));

        Cliente clienteModificado = clienteDetalle;
        if (cliente.equals(clienteDetalle)) {  return clienteModificado;
        }
        // Modifica el registro existente con los valores proporcionados
        clienteModificado = clienteRepository.getById(clienteId);
        clienteModificado.setNombre(clienteDetalle.getNombre());
        clienteModificado.setApellido(clienteDetalle.getApellido());
        return clienteRepository.save(clienteModificado);
    }

    // Eliminar Cliente
    @Transactional
    public Cliente deleteCliente(Long clienteId) {
        // Verifica que el Id exista
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID = " + clienteId));;

        clienteRepository.deleteById(clienteId);
        return cliente;
    }

}
