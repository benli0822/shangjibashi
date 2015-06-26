package com.sjbs.menudesigner.background.common.dao;

import com.sjbs.menudesigner.background.common.bo.Activity;
import com.sjbs.menudesigner.background.common.bo.ActivityDish;
import com.sjbs.menudesigner.background.common.bo.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface ActivityDishRepository extends CrudRepository<ActivityDish, Long> {
  List<ActivityDish> findActivityDishByActivityAndDish(Activity activity, Dish dish);
}
