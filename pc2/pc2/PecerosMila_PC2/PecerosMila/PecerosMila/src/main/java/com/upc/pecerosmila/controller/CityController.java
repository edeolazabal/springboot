package com.upc.pecerosmila.controller;

import com.upc.pecerosmila.model.dto.BudgetCityDTO;
import com.upc.pecerosmila.model.dto.CityDTO;
import com.upc.pecerosmila.model.entity.City;
import com.upc.pecerosmila.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        return new ResponseEntity<List<City>>(cityService.getAllCities(), HttpStatus.OK);
    }
    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCity(@PathVariable(value = "id") Long cityId) {
        return new ResponseEntity<City>(cityService.getCity(cityId), HttpStatus.OK);
    }
    @PostMapping("/cities")
    public ResponseEntity<City> insertCity (@RequestBody CityDTO city) {
        return new ResponseEntity<City>(cityService.insertCity(city), HttpStatus.CREATED);
    }
    @PutMapping("/city/{id}")
    public ResponseEntity<City> updateCity (@PathVariable (value = "id") Long cityId, @RequestBody CityDTO city) {
        return new ResponseEntity<City>(cityService.updateCity(cityId, city), HttpStatus.OK);
    }
    @GetMapping("/cities/dto")
    public ResponseEntity<List<BudgetCityDTO>> getAllBudgetCity() {
        return new ResponseEntity<List<BudgetCityDTO>>(cityService.getAllBudgetCity(), HttpStatus.OK);
    }
}
