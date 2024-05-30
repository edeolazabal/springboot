package com.upc.pc2api.controller;

import com.upc.pc2api.model.dto.PassengerDTO;
import com.upc.pc2api.model.dto.PassengerLineDTO;
import com.upc.pc2api.model.entity.Passenger;
import com.upc.pc2api.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test1")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passengers")
    public ResponseEntity<List<Passenger>> getAllEmployees() {
        return new ResponseEntity<List<Passenger>>(passengerService.getAllEPassengers(), HttpStatus.OK);
    }
    @GetMapping("/passengers/dto/{month}")
    public ResponseEntity<List<PassengerLineDTO>> findAllEmployeesCategory(@PathVariable (value = "month") Integer month) {
        return new ResponseEntity<List<PassengerLineDTO>>(passengerService.findAllEmployeesCategory(month), HttpStatus.OK);
    }
    @GetMapping("/passengers/{id}")
    public ResponseEntity<Passenger> findbyIdEmployees(@PathVariable (value = "id") Long passengerId) {
        return new ResponseEntity<Passenger>(passengerService.getPassenger(passengerId), HttpStatus.OK);
    }
    @PutMapping("/passengers/{id}")
    public ResponseEntity<Passenger> updateEmployee(@PathVariable (value = "id") Long passengerId, @RequestBody PassengerDTO passenger) {
        return new ResponseEntity<Passenger>(passengerService.updatePassenger(passengerId, passenger), HttpStatus.OK);
    }
    @PostMapping("/passengers")
    public ResponseEntity<Passenger> insertEmployee(@RequestBody PassengerDTO passenger) {
        return new ResponseEntity<Passenger>(passengerService.insertPassenger(passenger), HttpStatus.CREATED);
    }

}
