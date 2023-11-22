package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderUser {
    private List<String> ingredients;

    public OrderUser() {
        ingredients = new ArrayList<>();
    }

    public OrderUser(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
