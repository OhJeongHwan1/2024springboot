package com.sample.spring.api;

import com.sample.spring.api.request.CreateAndEditFoodRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodApi {
    @GetMapping("/foods")
    public String getfoods() {
        return "getFoods";
    }
    @GetMapping("/food/{foodId}")
    public String viewFood(@PathVariable("foodId") Long foodId) {
        return "viewFood " + foodId;
    }
    @PostMapping("/food")
    public String postFood(@RequestBody CreateAndEditFoodRequest request){
        return "postFood / name: " + request.getName() + ", address: " + request.getAddress();
    }
    @PutMapping("/food/{foodId}")
    public String putFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody CreateAndEditFoodRequest request
    ) {
        return "editFood " + foodId + ",name: " + request.getName() + ", address: " + request.getAddress();
    }
    @DeleteMapping("/food/{foodId}")
    public String deleteFood(@PathVariable("foodId") Long foodId) {
        return "deleteFood " + foodId;
    }
}