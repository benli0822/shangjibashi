package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface DishService {
    long addDish(Dish dish);
    long addDish(String name, String description, float price, boolean disabled);

    boolean removeDish(String dishName);

}
