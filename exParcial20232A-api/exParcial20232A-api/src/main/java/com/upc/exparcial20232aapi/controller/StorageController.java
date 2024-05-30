package com.upc.exparcial20232aapi.controller;

import com.upc.exparcial20232aapi.model.Storage;
import com.upc.exparcial20232aapi.model.StorageDto;
import com.upc.exparcial20232aapi.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@EnableMethodSecurity(prePostEnabled = true)
public class StorageController {
    final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "storage")
    @PreAuthorize("hasAuthority ('SUPERVISOR')")
    public ResponseEntity<Storage> insert(@RequestBody StorageDto storageDto)
    {
        return new ResponseEntity<>(storageService.insert(storageDto), HttpStatus.CREATED);
    }
}
