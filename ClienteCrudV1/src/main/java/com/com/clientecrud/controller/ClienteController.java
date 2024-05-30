package com.com.clientecrud.controller;

import com.com.clientecrud.model.Cliente;
import com.com.clientecrud.repository.ClienteRepository;
import com.com.clientecrud.service.ClienteService;
import org.apache.coyote.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todos Clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return new ResponseEntity<List<Cliente>>(clienteService.getAllClientes(), HttpStatus.OK);
    }
// Obtener por Id
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable (value = "id") Long clienteId)
            throws Exception {
       // return ResponseEntity.of(clienteService.getCliente(clienteId));
        return new ResponseEntity<Cliente>(clienteService.getCliente(clienteId), HttpStatus.OK);

    }
// Insertar Cliente
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<Cliente>(clienteService.insertCliente(cliente), HttpStatus.CREATED);
    }

    // Modificar Cliente
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId,
                                 @RequestBody Cliente clienteDetalle) throws Exception {
        return new ResponseEntity<Cliente>(clienteService.updateCliente(clienteId, clienteDetalle), HttpStatus.OK);
    }

// Eliminar Cliente
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable(value = "id") Long clienteId) {
        return new ResponseEntity<Cliente>(clienteService.deleteCliente(clienteId), HttpStatus.NO_CONTENT);
    }
}
