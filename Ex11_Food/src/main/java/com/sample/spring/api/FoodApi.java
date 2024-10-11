package com.sample.spring.api;

import com.sample.spring.api.request.CreateAndEditFoodRequest;
import com.sample.spring.api.response.FoodDetailView;
import com.sample.spring.model.FoodEntity;
import com.sample.spring.repository.FoodRepository;
import com.sample.spring.api.response.FoodView;
import com.sample.spring.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class FoodApi {
    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/foods")
    public List<FoodView> getfoods() {
        return foodService.getAllFoods();
    }
    @GetMapping("/food/{foodId}")
    public FoodDetailView viewFood(@PathVariable("foodId") Long foodId) {
        return foodService.getFoodDetail(foodId);
    }
    @PostMapping("/food")
    public FoodEntity postFood(@RequestBody CreateAndEditFoodRequest request){
        return foodService.createFood(request);
//        return "postFood / name: " + request.getName() + ", address: " + request.getAddress() + ", 메뉴[0]" + request.getMenus().get(1).getName();
    }
    @PutMapping("/food/{foodId}")
    public void editFood(
            @PathVariable("foodId") Long foodId,
            @RequestBody CreateAndEditFoodRequest request
    ) {

        foodService.editFood(foodId, request);
//        return "editFood " + foodId + ",name: " + request.getName() + ", address: " + request.getAddress();
    }
    @DeleteMapping("/food/{foodId}")
    public void deleteFood(@PathVariable("foodId") Long foodId) {
        foodService.deleteFood(foodId);

//        return "deleteFood " + foodId;
    }
}