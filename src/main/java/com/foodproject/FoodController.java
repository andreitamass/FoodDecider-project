package com.foodproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getReplaceFood(@RequestParam int index) {

        String responseBody = "Finns ingen mer ersättningsmat!";

        if (foodManager.replaceFood(index)) {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(getCurrenOptions());
        } else {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(responseBody);
        }
    }

}