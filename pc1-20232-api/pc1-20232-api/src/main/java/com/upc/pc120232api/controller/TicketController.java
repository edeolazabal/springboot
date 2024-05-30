package com.upc.pc120232api.controller;

import com.upc.pc120232api.model.dto.SalidaDto;
import com.upc.pc120232api.model.dto.TicketDto;
import com.upc.pc120232api.model.entity.Ticket;
import com.upc.pc120232api.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class TicketController {
    final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @PostMapping
    public ResponseEntity<Ticket> inserta (@RequestBody TicketDto ticketDto) {
        return new ResponseEntity<>(ticketService.inserta(ticketDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Ticket>> lista () {
        return new ResponseEntity<>(ticketService.lista(), HttpStatus.OK);
    }
    @GetMapping("/operations")
    public ResponseEntity<?> numberOfOperations () {
        Map<String, Integer> map = new HashMap<>();
        map.put("respuesta", ticketService.numberOfOperations());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @GetMapping("/quantity")
    public ResponseEntity<List<SalidaDto>> numberOfTickets (String stadium) {
 //       Map<String, Integer> map = new HashMap<>();
 //       map.put("respuesta", ticketService.numberOfTickets(stadium));
 //       return new ResponseEntity<>(map, HttpStatus.OK);
        return new ResponseEntity<>(ticketService.numberOfTickets(stadium), HttpStatus.OK);
    }
    @GetMapping("/amount")
    public ResponseEntity<?> ticketsAmount (LocalDate matchDate) {
        Map<String, Double> map = new HashMap<>();
        map.put("respuesta", ticketService.ticketAmount(matchDate));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
