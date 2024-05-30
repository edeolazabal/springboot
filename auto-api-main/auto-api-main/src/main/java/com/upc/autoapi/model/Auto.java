package com.upc.autoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String brand;
    private Double price;
    private Double tax;

    public Auto (String brand, Double price) {
        this.brand = brand;
        this.price = price;
        this.tax = price * 0.18;
    }
}
