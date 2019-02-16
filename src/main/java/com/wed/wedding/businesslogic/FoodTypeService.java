package com.wed.wedding.businesslogic;

import com.wed.wedding.Food;
import com.wed.wedding.FoodType;
import com.wed.wedding.Response;
import com.wed.wedding.database.FoodTypeDao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Service
public class FoodTypeService {

    private FoodTypeDao foodTypeDao;
    private ResourceBundle bundle;

    public FoodTypeService(FoodTypeDao foodTypeDao) {
        this.foodTypeDao = foodTypeDao;
        try{
            bundle = ResourceBundle.getBundle("userMessages");
        } catch (MissingResourceException mre) {
            bundle = ResourceBundle.getBundle("userMessages", new Locale("en", "GB"));
        }
    }

    public Response createFoodType(int typeId, String type) {
        List<FoodType> foodTypes = foodTypeDao.listFoodTypes();
        for(FoodType foodType: foodTypes) {
            if(foodType.equals(type))
            return new Response(false, bundle.getString("label.usedFoodType"));
        }
        return new Response(true, type + " " + bundle.getString("label.newFoodType"));
    }

    public List<FoodType> listFoodTypes() {
        return foodTypeDao.listFoodTypes();
    }
}
