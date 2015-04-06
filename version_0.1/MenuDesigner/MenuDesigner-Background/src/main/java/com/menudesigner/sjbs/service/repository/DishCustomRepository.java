package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by JIN Benli on 31/01/15.
 */
public interface DishCustomRepository
{

    Page<Dish> findDishByTypesDescription(String description, Pageable pageable);

}
