package com.upc.pecerosmila.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String region;
    private Number monthOfYear;
    private Number population;
    @ManyToOne()
    @JoinColumn(name = "budgetcityId")
    private BudgetCity budgetCity;
}