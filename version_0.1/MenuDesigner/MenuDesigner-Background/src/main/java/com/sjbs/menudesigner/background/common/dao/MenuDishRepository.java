package com.sjbs.menudesigner.background.common.dao;

import com.sjbs.menudesigner.background.common.bo.Dish;
import com.sjbs.menudesigner.background.common.bo.Menu;
import com.sjbs.menudesigner.background.common.bo.MenuDish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface MenuDishRepository extends CrudRepository<MenuDish, Long> {
  List<MenuDish> findMenuDishByMenuAndDish(Menu menu, Dish dish);
}
