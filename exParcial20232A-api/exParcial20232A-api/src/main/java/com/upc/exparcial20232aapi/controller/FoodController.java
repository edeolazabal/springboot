package com.upc.exparcial20232aapi.controller;

import com.upc.exparcial20232aapi.model.FoodDto;
import com.upc.exparcial20232aapi.model.FoodOutDto;
import com.upc.exparcial20232aapi.model.SumOfKgDto;
import com.upc.exparcial20232aapi.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@EnableMethodSecurity(prePostEnabled = true)
public class FoodController {

    final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping(value = "food")
    @PreAuthorize("hasAuthority ('OPERARIO')")
    public ResponseEntity<FoodOutDto> insert(@RequestBody FoodDto foodDto)
    {
        return new ResponseEntity<>(foodService.insert(foodDto), HttpStatus.CREATED);
    }
    @GetMapping(value = "food/{id}")
    @PreAuthorize("hasAuthority ('SUPERVISOR')")
    public ResponseEntity<SumOfKgDto> find(@PathVariable(value = "id") Integer storageId)
    {
        return new ResponseEntity<>(foodService.sumOfKg(storageId), HttpStatus.OK);
    }
}
