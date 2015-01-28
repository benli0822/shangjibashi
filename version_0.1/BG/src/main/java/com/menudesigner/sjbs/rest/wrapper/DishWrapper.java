package com.menudesigner.sjbs.rest.wrapper;

/**
 * Created by JIN Benli on 28/01/15.
 */
public class DishWrapper {
    long dish_id;
    int quantity;

    public DishWrapper() {
    }

    public long getDish_id() {
        return dish_id;
    }

    public void setDish_id(long dish_id) {
        this.dish_id = dish_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
