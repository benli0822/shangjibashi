package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.service.repository.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Dish Service Implementation for all operational action
 * <p/>
 * Created by JIN Benli on 10/11/14.
 */
@Component("dishService")
@Transactional
public class DishServiceImpl implements DishService {

    private static final Logger logger = LoggerFactory.getLogger(DishServiceImpl.class);

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    /**
     * Adding a dish with checking its uniqueness
     * 1. Return true and add if not exist
     * 2. Return false if already has
     *
     * @param dish Dish entity object that need to be added
     * @return
     */
    @Override
    public long addDish(Dish dish) {
        logger.debug("Try adding dish: " + dish.toString());

        //TODO create dish with params
        if (dishRepository.findDishByName(dish.getName()).size() == 0) {
            Dish theDish = dishRepository.save(dish);
            logger.info("Dish " + dish.toString() + " added!");
            return theDish.getId();
        } else {
            logger.error("Dish " + dish.toString() + " existed!");
            return -1L;
        }
    }

    /**
     * Removing a dish with the given name
     * 1. Return true if found and delete the record
     * 2. Return false if not found
     *
     * @param dishName The name of dish
     * @return
     */
    @Override
    public boolean removeDish(String dishName) {
        logger.debug("Try removing dish: " + dishName);
        if (dishRepository.findDishByName(dishName).size() == 0) {
            logger.error("Dish " + dishName + " not found!");
            return false;
        } else {
            logger.debug("Deleting requested dish " + dishName);
            List<Dish> toDeleteDish = dishRepository.findDishByName(dishName);
            Iterator<Dish> iterator = toDeleteDish.iterator();
            while (iterator.hasNext()) {
                Dish dish = iterator.next();
                logger.debug("Deleted dish " + dish.toString());
                dishRepository.delete(dish);
            }
            logger.info("Dish removed!");
            return true;
        }
    }
}
