package com.upc.exparcial20232aapi.service;

import com.upc.exparcial20232aapi.model.Storage;
import com.upc.exparcial20232aapi.model.StorageDto;
import com.upc.exparcial20232aapi.repository.StorageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StorageService {
    final StorageRepository storageRepository;
    final ModelMapper modelMapper;

    public StorageService(StorageRepository storageRepository, ModelMapper modelMapper) {
        this.storageRepository = storageRepository;
        this.modelMapper = modelMapper;
    }
    public Storage insert (StorageDto storageDto) {
        Storage storage = modelMapper.map(storageDto, Storage.class);

        return storageRepository.save(storage);
    }
}
