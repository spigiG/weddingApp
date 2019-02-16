package com.wed.wedding.userinterface;

import com.wed.wedding.FoodType;
import com.wed.wedding.Response;
import com.wed.wedding.businesslogic.FoodTypeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodTypeController {
    private FoodTypeService foodTypeService;

    public FoodTypeController(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    @RequestMapping(value = "/api/foodtypes", method = RequestMethod.POST)
    public Response createFoodType(@RequestBody FoodType foodType) {
        return foodTypeService.createFoodType(foodType.getTypeId(), foodType.getType());
    }

    @RequestMapping(value = "/api/foodtypes", method = RequestMethod.GET)
    public List<FoodType> listFoodTypes() {
        System.out.println("in end point");
        return foodTypeService.listFoodTypes();
    }

}
