package com.sjbs.menudesigner.background.common.repository;

import com.sjbs.menudesigner.background.common.bo.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by JIN Benli on 31/01/15.
 */
public interface DishCustomRepository {

  Page<Dish> findDishByTypesDescription(String description, Pageable pageable);

}