package com.upc.pc120232api.service;

import com.upc.pc120232api.model.dto.SalidaDto;
import com.upc.pc120232api.model.dto.TicketDto;
import com.upc.pc120232api.model.entity.Ticket;
import com.upc.pc120232api.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    public List<Ticket> lista () { return ticketRepository.findAll(); }

    public Integer numberOfOperations() { return ticketRepository.numberOfOperations(); }

    public List<SalidaDto> numberOfTickets(String stadium) {

        return  ticketRepository.listaPorStadium(stadium)
                .stream()
                .map(tuple -> new SalidaDto(
                        tuple.get("tribune", String.class),
                        tuple.get("quantity", Integer.class),
                        tuple.get("price", Double.class),
                        tuple.get("match_date", Date.class),
                        tuple.get("stadium", String.class),
                        tuple.get("amount", Double.class)))
                .toList();

    }
    public Double ticketAmount(LocalDate matchDate) { return ticketRepository.ticketAmmount(matchDate); }
    public Ticket inserta (TicketDto ticketDto) {
        ModelMapper modelMapper = new ModelMapper();

        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        ticket.setIssueDate(new Date());

        return ticketRepository.save(ticket);
        /*
        // Construye ticket
        ticket.setTribune(ticketDto.getTribune());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setQuantity(ticketDto.getQuantity());
        ticket.setMatchDate(ticketDto.getMatchDate());
        ticket.setIssueDate(new Date());
        */


    }
}
