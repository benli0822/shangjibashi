package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.service.repository.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Dish Service Implementation for all operational action
 * <p/>
 * Created by JIN Benli on 10/11/14.
 */
@Service
@Component("dishService")
@Transactional
public class DishServiceImpl implements DishService {

    private static final Logger logger = LoggerFactory.getLogger(DishServiceImpl.class);

    private final DishRepository dishRepository;

    private final TypeService typeService;

    private final OptionService optionService;

    private final FileService fileService;

    private final MenuService menuService;

    private final ActivityService activityService;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, TypeService typeService, OptionService optionService, FileService fileService, MenuService menuService, ActivityService activityService) {
        this.dishRepository = dishRepository;
        this.typeService = typeService;
        this.optionService = optionService;
        this.fileService = fileService;
        this.menuService = menuService;
        this.activityService = activityService;
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

    @Override
    public long addDish(String name, String description, float price, boolean disabled) {
        logger.debug("Try adding dish");
        Dish newDish = new Dish();
        newDish.setName(name);
        newDish.setDescription(description);
        newDish.setPrice(price);
        newDish.setDisabled(disabled);

        return this.addDish(newDish);
    }

    @Override
    public long addDish(String name, String description, float price, boolean disabled, Date start_date, Date end_date, Time start_time, Time end_time) {
        logger.debug("Try adding dish");

        long dish_id = this.addDish(name, description, price, disabled);

        this.setPeriodToDish(dish_id, start_date, end_date, start_time, end_time);

        return dish_id;
    }

    @Override
    public void setPeriodToDish(long dish_id, Date start_date, Date end_date, Time start_time, Time end_time) {
        Dish dish = dishRepository.findOne(dish_id);
        dish.setStart_date(start_date);
        dish.setEnd_date(end_date);
        dish.setStart_time(start_time);
        dish.setEnd_time(end_time);
        dishRepository.save(dish);
    }

    @Override
    public void setImagePath(String imagePath) {
        // TODO set the image path to dish
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
            for (Dish dish : toDeleteDish) {
                logger.debug("Deleted dish " + dish.toString());
                // when the dish has been found, first should check all its associations
                // type association
                boolean res1 = typeService.removeDishFromType(dish);
                assert res1;
                // menu association
                boolean res2 = menuService.removeDishFromMenu(dish);
                assert res2;
                // activity association

                // option association

                // file association, caution here should determine if we really need to delete the file

                // command ? should be considered, if this will crash all database

                dishRepository.delete(dish);
            }
            logger.info("Dish removed!");
            return true;
        }
    }
}
