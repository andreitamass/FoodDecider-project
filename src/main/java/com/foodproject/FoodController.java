package com.foodproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class FoodController {

    private FoodManager foodManager = new FoodManager();

    @GetMapping("/current")
    public ArrayList<FoodOptions> getCurrenOptions() {
        return foodManager.getCurrentOptions();
    }

    @GetMapping("/foods")
    public ArrayList<FoodOptions> getFoods () {
        return foodManager.getAllFoods();
    }

    @PostMapping("/replace")
    public ArrayList<FoodOptions> getReplaceFood(@RequestParam int index) {
        if (foodManager.replaceFood(index)) {
            return foodManager.getCurrentOptions();
        } else {
            return "Misslyckad"; //changing to ResponseEntity
        }
    }

}