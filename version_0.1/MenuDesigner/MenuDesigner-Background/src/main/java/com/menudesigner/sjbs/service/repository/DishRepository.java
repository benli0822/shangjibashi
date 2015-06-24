package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Dish;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface DishRepository extends PagingAndSortingRepository<Dish, Long>, DishCustomRepository {

  List<Dish> findDishByName(String name);
}