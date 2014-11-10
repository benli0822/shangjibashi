package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface DishService {
    Boolean addDish(Dish dish);

    Boolean removeDish(String dishName);

}
