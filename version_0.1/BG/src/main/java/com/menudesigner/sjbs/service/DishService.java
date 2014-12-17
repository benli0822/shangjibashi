package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface DishService {
    boolean addDish(Dish dish);

    boolean removeDish(String dishName);

}
