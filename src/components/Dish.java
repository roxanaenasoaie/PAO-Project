package components;

import java.util.List;

public class Dish extends Identity{
    static Integer ID = 0;

    private String dishName;
    private Float dishWeight, dishPrice;
    private List<String> ingredients;

    public Dish(String dishName, Float dishWeight, Float dishPrice, List<String> ingredients) {
        super(ID);
        ID += 1;

        this.dishName = dishName;
        this.dishWeight = dishWeight;
        this.dishPrice = dishPrice;
        this.ingredients = ingredients;
    }

    public static Integer getID() {
        return ID;
    }

    public static void setID(Integer ID) {
        Dish.ID = ID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Float getDishWeight() {
        return dishWeight;
    }

    public void setDishWeight(Float dishWeight) {
        this.dishWeight = dishWeight;
    }

    public Float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", dishWeight=" + dishWeight +
                ", dishPrice=" + dishPrice +
                ", ingredients=" + ingredients +
                ", id=" + id +
                '}';
    }
}
