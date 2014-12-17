package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface DishService {
    long addDish(Dish dish);

    boolean removeDish(String dishName);

}
