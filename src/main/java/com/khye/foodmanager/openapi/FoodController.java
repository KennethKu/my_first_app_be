package com.khye.foodmanager.openapi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khye.foodmanager.model.Food;
import com.khye.foodmanager.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	private final FoodService foodService;

	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	@GetMapping("")
	public ResponseEntity<List<Food>> getAllFoods() {
		List<Food> foods = foodService.findAllFoods();
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable("id") Long id) {
		Food food = foodService.findFoodById(id);
		return new ResponseEntity<>(food, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Food> addFood(@RequestBody Food food) {
		Food newFood = foodService.addFood(food);
		return new ResponseEntity<>(newFood, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Food> updateFood(@RequestBody Food food) {
		Food updateFood = foodService.updateFood(food);
		return new ResponseEntity<>(updateFood, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteFood(@PathVariable("id") Long id) {
		foodService.deleteFoodById(id);
	}
}
