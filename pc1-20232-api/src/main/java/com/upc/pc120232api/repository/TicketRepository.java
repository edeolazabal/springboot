package com.upc.pc120232api.repository;

import com.upc.pc120232api.model.dto.SalidaDto;
import com.upc.pc120232api.model.entity.Ticket;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "SELECT COUNT(*) operations FROM ticket", nativeQuery = true)
    Integer numberOfOperations();

    @Query(value = "SELECT tribune, quantity, price, match_date, stadium, (price * quantity) amount FROM ticket WHERE stadium = ?1", nativeQuery = true)
    List<Tuple> listaPorStadium(String stadium);

    @Query(value = "SELECT SUM(quantity * price) amount FROM ticket WHERE match_date >= ?1", nativeQuery = true)
    Double ticketAmmount (LocalDate matchDate);

}
