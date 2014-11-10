package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface DishRepository extends CrudRepository<Dish, Long> {
    List<Dish> findDishByName(String name);

}
