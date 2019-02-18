package com.wed.wedding.userinterface;

import com.wed.wedding.Food;
import com.wed.wedding.Response;
import com.wed.wedding.businesslogic.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/foods", method = RequestMethod.GET)
    public List<Food> listFoods() {
        return foodService.listFoods();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/foodcreate", method = RequestMethod.POST)
    public Response createFood(@RequestBody Food food) {
        return foodService.createFood(food.getType().getTypeId(), food.getTitle(), food.getDescription());
    }
}
