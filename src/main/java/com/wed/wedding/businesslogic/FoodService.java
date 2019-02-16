package com.wed.wedding.businesslogic;

import com.wed.wedding.Food;
import com.wed.wedding.FoodType;
import com.wed.wedding.Response;
import com.wed.wedding.database.FoodDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Service
public class FoodService {
    public static final Logger LOGGER = LoggerFactory.getLogger(FoodService.class);
    private FoodDao foodDao;
    private ResourceBundle bundle;

    public FoodService(FoodDao foodDao) {
        this.foodDao = foodDao;
        try {
            bundle = ResourceBundle.getBundle("userMessages");
        } catch (MissingResourceException mre) {
            bundle = ResourceBundle.getBundle("userMessages", new Locale("en", "GB"));
        }
    }

    public Response createFood(FoodType type, String title, String description) {
        List<Food> foods = foodDao.listFoods();
        for(Food food: foods) {
            if(food.equals(title)) {
                return new Response(false, bundle.getString("label.usedFood"));
            }
        }
        return new Response(true, bundle.getString("label.newFood"));
    }

    public List<Food> listFoods() {
        return foodDao.listFoods();
    }
}
