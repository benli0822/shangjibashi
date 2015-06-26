package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.Activity;
import com.sjbs.menudesigner.background.domain.ActivityDish;
import com.sjbs.menudesigner.background.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface ActivityDishRepository extends CrudRepository<ActivityDish, Long> {
  List<ActivityDish> findActivityDishByActivityAndDish(Activity activity, Dish dish);
}
