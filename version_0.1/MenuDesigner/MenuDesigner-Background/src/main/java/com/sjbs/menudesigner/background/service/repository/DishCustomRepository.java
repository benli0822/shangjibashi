package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by JIN Benli on 31/01/15.
 */
public interface DishCustomRepository {

  Page<Dish> findDishByTypesDescription(String description, Pageable pageable);

}
