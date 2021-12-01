package com.khye.foodmanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khye.foodmanager.model.Food;

public interface FoodRepo extends JpaRepository<Food, Long> {

}
