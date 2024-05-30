package com.upc.pc2api.model.dto;

import com.upc.pc2api.model.entity.Line;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO implements Serializable {
    private Long id;
    private String firstname;
    private String lastname;
    private Integer monthOfYear;
    private Integer quantity;
    private Long lineId;
}
