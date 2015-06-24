package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Menu;
import com.menudesigner.sjbs.domain.MenuDish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface MenuDishRepository extends CrudRepository<MenuDish, Long> {
  List<MenuDish> findMenuDishByMenuAndDish(Menu menu, Dish dish);
}
