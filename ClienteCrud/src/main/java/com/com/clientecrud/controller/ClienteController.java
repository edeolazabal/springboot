package com.com.clientecrud.controller;

import com.com.clientecrud.model.Cliente;
import com.com.clientecrud.repository.ClienteRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
// Obtener todos Clientes
    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
// Obtener por Id
    @GetMapping("/clientes/{id}")
    public Optional<Cliente> getCliente(@PathVariable (value = "id") Long clienteId) {
        return clienteRepository.findById(clienteId);
     }
// Insertar Cliente
    @PostMapping("/clientes")
    public Cliente insertCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
// Modificar Cliente
    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@PathVariable(value = "id") Long clienteId,
                                 @RequestBody Cliente clienteDetalle) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        Cliente clienteModificado = new Cliente("No existe en BD", "No se actualiza");
        if (cliente.stream().count() == 0) {  return clienteModificado; }

        clienteModificado = clienteRepository.getById(clienteId);
        clienteModificado.setNombre(clienteDetalle.getNombre());
        clienteModificado.setApellido(clienteDetalle.getApellido());
        return clienteRepository.save(clienteModificado);
    }

// Eliminar Cliente
    @DeleteMapping("/clientes/{id}")
    public String deleteCliente(@PathVariable(value = "id") Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.stream().count() == 0) {
            return "Registro con ID:: " + clienteId + " NO existe";
        }
        clienteRepository.deleteById(clienteId);
        return "Registro con ID:: " + clienteId + " ha sido eliminado";
    }
}
