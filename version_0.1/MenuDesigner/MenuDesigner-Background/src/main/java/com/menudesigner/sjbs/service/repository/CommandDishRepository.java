package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Command;
import com.menudesigner.sjbs.domain.CommandDish;
import com.menudesigner.sjbs.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandDishRepository extends CrudRepository<CommandDish, Long> {
    List<CommandDish> findCommandDishByCommandAndDish(Command command, Dish dish);
}
