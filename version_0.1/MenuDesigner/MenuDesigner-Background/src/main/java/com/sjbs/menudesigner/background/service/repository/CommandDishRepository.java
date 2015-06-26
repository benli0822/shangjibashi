package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.Command;
import com.sjbs.menudesigner.background.domain.CommandDish;
import com.sjbs.menudesigner.background.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandDishRepository extends CrudRepository<CommandDish, Long> {
  List<CommandDish> findCommandDishByCommandAndDish(Command command, Dish dish);
}
