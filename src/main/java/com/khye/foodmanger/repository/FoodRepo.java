package com.khye.foodmanger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khye.foodmanager.model.Food;

public interface FoodRepo extends JpaRepository<Food, Long> {

	void deleteFoodById(Long id);

	Optional<Food> findFoodById(Long id);

}
