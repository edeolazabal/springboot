package com.upc.alumnoapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private Double salaryByHour;
 //   @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
 //   private Set<Employee> employes = new HashSet<>();

}
