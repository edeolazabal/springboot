package com.upc.pecerosmila.service;

import com.upc.pecerosmila.model.dto.BudgetCityDTO;
import com.upc.pecerosmila.model.dto.CityDTO;
import com.upc.pecerosmila.model.entity.BudgetCity;
import com.upc.pecerosmila.model.entity.City;
import com.upc.pecerosmila.repository.BudgetCityRepository;
import com.upc.pecerosmila.repository.CityRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    BudgetCityRepository budgetCityRepository;

    //Lectura registros

    @Transactional (readOnly = true)
    public List<City> getAllCities() { return cityRepository.findAll(); }

    //Lectura mediante ID

    @Transactional (readOnly = true)
    public City getCity(Long cityId) {
        return  cityRepository.findById( cityId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con Id = "+ cityId));

    }

    //Registrar ciudad

    @Transactional
    public City insertCity (CityDTO cityDetails) {
        City cit = new City();
        BudgetCity bud;
        cit.setName(cityDetails.getName());
        cit.setRegion(cityDetails.getRegion());
        cit.setMonthOfYear(cityDetails.getMonthOfYear());
        cit.setPopulation(cityDetails.getPopulation());
        //Budget City
        bud = budgetCityRepository.findById(cityDetails.getBudgetCityId())
                .orElse(bud=null);
        cit.setBudgetCity(bud);

        return cityRepository.save(cit);
    }

    @Transactional
    public City updateCity (Long cityId, CityDTO cityDetails) {
        //Lectura mediante PK ID
        City city = cityRepository.findById(cityId)
                .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ID = "+ cityId));
        BudgetCity bud;

        //Revisar cambios en campos

        if (city.getBudgetCity() != null)
            if (city.getBudgetCity().getId().equals(cityDetails.getBudgetCityId()) &&
                city.getName().equals(cityDetails.getName()) &&
                city.getRegion().equals(cityDetails.getRegion()) &&
                city.getMonthOfYear().equals(cityDetails.getMonthOfYear()) &&
                city.getPopulation().equals(cityDetails.getPopulation()) )
                return city;

        city.setName(cityDetails.getName());
        city.setRegion(cityDetails.getRegion());
        city.setMonthOfYear(cityDetails.getMonthOfYear());
        city.setPopulation(cityDetails.getPopulation());
        bud = budgetCityRepository.findById((cityDetails.getBudgetCityId()))
                .orElse(bud = null);
        city.setBudgetCity(bud);
        return cityRepository.save(city);
    }

    @Transactional(readOnly = true)
    public List<BudgetCityDTO> getAllBudgetCity() {
        List<BudgetCityDTO> listaDTO = new ArrayList<BudgetCityDTO>();
        List<City> cities = cityRepository.findAll();
        BudgetCity budgetCity;
        for (City city: cities)
        {
            BudgetCityDTO dto = new BudgetCityDTO();
            budgetCity = budgetCityRepository.findBudgetCityByCity(city.getId());

            if (budgetCity.getId() == 1) {
                dto.setClassification("Ciudad Grande");
                dto.setBudgetAmount(100000.000);
            } else if (budgetCity.getId() == 2) {
                dto.setClassification("Ciudad Mediana");
                dto.setBudgetAmount(10000.000);
            } else if (budgetCity.getId()==3) {
                dto.setClassification("Ciudad Pequeña");
                dto.setBudgetAmount(1000.000);
            }
            dto.setId(city.getId());
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
