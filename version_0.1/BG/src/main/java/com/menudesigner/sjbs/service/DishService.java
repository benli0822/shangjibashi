package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface DishService {
    /**
     * Make sure this is the unique dish created in repository
     * @param dish
     * @return
     */
    long addDish(Dish dish);

    /**
     * This is where we create a basic dish with no association
     * @param name
     * @param description
     * @param price
     * @param disabled
     * @return
     */
    long addDish(String name, String description, float price, boolean disabled);

    /**
     * Remove a dish
     * @param dishName
     * @return
     */
    boolean removeDish(String dishName);

}
