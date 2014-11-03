package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface DishRepository {
    List<Dish> findDishByName(String name);
}
