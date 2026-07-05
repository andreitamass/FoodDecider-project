package com.foodproject;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @GetMapping("/foods")
    public ArrayList<FoodOptions> getFoods() {
        
        FoodData foodData = new FoodData();

        return foodData.getAllFoodOptions();

    }
}