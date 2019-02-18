package com.wed.wedding;

public class FoodType {
    private int typeId;
    private String type;

    public FoodType(int typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }
	
	public FoodType(int typeId) {
        this.typeId = typeId;
    }

    public FoodType() {}

    public FoodType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getType() {
        return type;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                '}';
    }
}
