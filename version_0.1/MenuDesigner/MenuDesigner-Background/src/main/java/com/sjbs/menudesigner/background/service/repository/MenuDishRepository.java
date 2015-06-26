package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.Dish;
import com.sjbs.menudesigner.background.domain.Menu;
import com.sjbs.menudesigner.background.domain.MenuDish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface MenuDishRepository extends CrudRepository<MenuDish, Long> {
  List<MenuDish> findMenuDishByMenuAndDish(Menu menu, Dish dish);
}
