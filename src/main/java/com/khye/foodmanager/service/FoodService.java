package com.khye.foodmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khye.foodmanager.exception.FoodNotFoundException;
import com.khye.foodmanager.model.Food;
import com.khye.foodmanger.repository.FoodRepo;

@Service
public class FoodService {
	private final FoodRepo foodRepo;

	@Autowired
	public FoodService(FoodRepo foodRepo) {
		this.foodRepo = foodRepo;
	}

	public Food addFood(Food food) {
		food.setProductCode(UUID.randomUUID().toString());
		return foodRepo.save(food);
	}

	public List<Food> findAllFoods() {
		return foodRepo.findAll();
	}

	public Food updateFood(Food food) {
		return foodRepo.save(food);
	}

	public Food findFoodById(Long id) {
		return foodRepo.findFoodById(id)
				.orElseThrow(() -> new FoodNotFoundException("Food by id " + id + "was not found."));

	}

	public void deleteFoodById(Long id) {
		foodRepo.deleteFoodById(id);
	}
}
