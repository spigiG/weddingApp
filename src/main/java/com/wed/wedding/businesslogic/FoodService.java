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

    public Response createFood(int type, String title, String description) {
        if(type == 0) {
            return new Response(false, "Rossz paraméter");
        }
        Response result = checkInputValue(title, description);
        if(result != null) {
            return result;
        }

        foodDao.createFood(type, title, description);
        return new Response(true, "Az új étel létrehozva");
    }
	
	private Response checkInputValue(String title, String description) {
        Response result = null;
        List<Food> foods = listFoods();

        if(isEmpty(title) || isEmpty(description)) {
            result = new Response(false, "A paraméter nem megfelelő");
        }

        return result;
    }

    private boolean isEmpty(String word) {
        if(word == null || word.length() == 0) {
            return true;
        }

        return false;
    }

    public List<Food> listFoods() {
        return foodDao.listFoods();
    }
}
