package com.upc.alumnoapi.model.entity;

import com.upc.alumnoapi.util.AuthorityName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated (EnumType.STRING)
    private AuthorityName name;
}
