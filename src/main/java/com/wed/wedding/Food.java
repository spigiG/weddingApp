package com.wed.wedding;

public class Food {
    private FoodType type;
    private String title;
    private String description;

    public Food(FoodType type, String title, String description) {
        this.type = type;
        this.title = title;
        this.description = description;
    }

    public Food(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Food() {
    }

    public FoodType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


