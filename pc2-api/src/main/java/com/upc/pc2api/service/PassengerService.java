package com.upc.pc2api.service;

import com.upc.pc2api.model.dto.PassengerDTO;
import com.upc.pc2api.model.dto.PassengerLineDTO;
import com.upc.pc2api.model.entity.Line;
import com.upc.pc2api.model.entity.Passenger;
import com.upc.pc2api.repository.LineRepository;
import com.upc.pc2api.repository.PassengerRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {
    @Autowired
    LineRepository lineRepository;
    @Autowired
    PassengerRepository passengerRepository;

    @Transactional(readOnly = true)
    public List<Passenger> getAllEPassengers() {
        return passengerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<PassengerLineDTO> findAllEmployeesCategory(Integer month) {
        List<PassengerLineDTO> listaDTO = new ArrayList<PassengerLineDTO>();
        List<Passenger> pasengers = passengerRepository.findAllPassengersByMonthOrderByLastname(month);
        Line line;
        PassengerLineDTO dto;
        String d = "";

        for (Passenger pax: pasengers) {
            dto = new PassengerLineDTO();
            line = lineRepository.findLineByPassenger(pax.getId());
            dto.setMonth(monthInLetters(pax.getMonthOfYear()));
            dto.setFullName(pax.getLastname() + ", " + pax.getFirstname());
            dto.setQuantity(pax.getQuantity());

            if (line != null)
                { dto.setPrice(line.getPrice()); }
            else
                {dto.setPrice(0.0);}
            // Pago doble en Julio y Diciembre
            dto.setTotalAmount(dto.getQuantity() * dto.getPrice());
            //System.out.println("dto.getMonth() "+dto.getMonth());
            if (pax.getMonthOfYear().equals(12))
                dto.setTotalAmount(2 * dto.getTotalAmount());
            d = LocalDate.now() + " " + LocalTime.now();
            dto.setReportDateTime(d);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    private String monthInLetters(int month) {
        String res = "";
        switch (month) {
            case 1: { res = "ENERO"; break;}
            case 2: { res = "FEBRERO"; break;}
            case 3: { res = "MARZO"; break;}
            case 4: { res = "ABRIL"; break;}
            case 5: { res = "MAYO"; break;}
            case 6: { res = "JUNIO"; break;}
            case 7: { res = "JULIO"; break;}
            case 8: { res = "AGOSTO"; break;}
            case 9: { res = "SETIEMBRE"; break;}
            case 10: { res = "OCTUBRE"; break;}
            case 11: { res = "NOVIEMBRE"; break;}
            case 12: { res = "DICIEMBRE"; break;}
        }
        return res;
    }


    @Transactional(readOnly = true)
    public Passenger getPassenger(Long passengerId) {
        return passengerRepository.findById(passengerId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Pasajero con ID = " + passengerId + " no existe"));
    }

    @Transactional
    public Passenger insertPassenger (PassengerDTO passengerDetails) {
        Passenger pax = new Passenger();
        Line line;
        pax.setFirstname(passengerDetails.getFirstname());
        pax.setLastname(passengerDetails.getLastname());
        pax.setQuantity(passengerDetails.getQuantity());
        if (passengerDetails.getMonthOfYear() < 1 || passengerDetails.getMonthOfYear() > 12)
            throw new OpenApiResourceNotFoundException("Mes no puede ser mayor que 12 o menor que 1");
        pax.setMonthOfYear(passengerDetails.getMonthOfYear());
        // Línea
        line = lineRepository.findById(passengerDetails.getLineId())
                .orElse(line = null);
        pax.setLine(line);
        return passengerRepository.save(pax);
    }

    @Transactional
    public Passenger updatePassenger(Long passengerId, PassengerDTO passengerDetails)  {
         Passenger pax  = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Pasajero con ID = " + passengerId + " no existe"));
        Line line;
        pax.setFirstname(passengerDetails.getFirstname());
        pax.setLastname(passengerDetails.getLastname());
        pax.setQuantity(passengerDetails.getQuantity());
        if (passengerDetails.getMonthOfYear() < 1 || passengerDetails.getMonthOfYear() > 12)
            throw new OpenApiResourceNotFoundException("Mes no puede ser mayor que 12 o menor que 1");
        pax.setMonthOfYear(passengerDetails.getMonthOfYear());
        // Línea
        line = lineRepository.findById(passengerDetails.getLineId())
                .orElse(line = null);
        pax.setLine(line);
        return passengerRepository.save(pax);
    }
}
