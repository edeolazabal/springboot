package com.upc.exparcial20232aapi.service;

import com.upc.exparcial20232aapi.model.*;
import com.upc.exparcial20232aapi.repository.FoodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class FoodService {
    final FoodRepository foodRepository;

    final ModelMapper modelMapper;

    public FoodService(FoodRepository foodRepository, ModelMapper modelMapper) {
        this.foodRepository = foodRepository;
        this.modelMapper = modelMapper;
    }
    public FoodOutDto insert (FoodDto foodDto) {
        Food food = modelMapper.map(foodDto, Food.class);
        food.setId(0);
        food = foodRepository.save(food);
        return modelMapper.map(food, FoodOutDto.class);

     }
    public SumOfKgDto sumOfKg (Integer storageId) {
        SumOfKgDto sumDto = new SumOfKgDto();
        sumDto.setQuantity(foodRepository.sumOfKg(storageId));
        return sumDto;
    }

}
