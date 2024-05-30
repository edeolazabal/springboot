package com.upc.pc120232api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String tribune;
    Integer quantity;
    Double price;
    Date matchDate;
    Date issueDate;
    String stadium;

}
