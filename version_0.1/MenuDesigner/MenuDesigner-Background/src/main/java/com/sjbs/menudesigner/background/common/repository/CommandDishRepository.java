package com.sjbs.menudesigner.background.common.repository;

import com.sjbs.menudesigner.background.common.bo.Command;
import com.sjbs.menudesigner.background.common.bo.CommandDish;
import com.sjbs.menudesigner.background.common.bo.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandDishRepository extends CrudRepository<CommandDish, Long> {
  List<CommandDish> findCommandDishByCommandAndDish(Command command, Dish dish);
}
