package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Activity;
import com.menudesigner.sjbs.domain.ActivityDish;
import com.menudesigner.sjbs.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface ActivityDishRepository extends CrudRepository<ActivityDish, Long> {
    List<ActivityDish> findActivityDishByActivityAndDish(Activity activity, Dish dish);
}
