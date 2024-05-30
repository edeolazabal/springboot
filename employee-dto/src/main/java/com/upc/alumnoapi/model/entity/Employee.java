package com.upc.alumnoapi.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstname;
    private String lastname;
    private Integer monthOfYear;
    @Column(name = "worked_hours", nullable = false, scale = 2)
    private Double  workedHours;
    @ManyToOne()
    @JoinColumn(name = "categoryId")
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "category_id")
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

//    @Column(name = "salary_by_hour", nullable = false, scale = 2)
//    private Double  salaryByHour;
}
