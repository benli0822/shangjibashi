package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface DishService
{
    /**
     * Make sure this is the unique dish created in repository
     *
     * @param dish
     * @return
     */
    long addDish(Dish dish);

    /**
     * This is where we create a basic dish with no association
     *
     * @param name
     * @param description
     * @param price
     * @param disabled
     * @return
     */
    long addDish(String name, String description, float price, boolean disabled);

    /**
     * This is where we create a basic dish with period
     *
     * @param name
     * @param description
     * @param price
     * @param disabled
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     * @return
     */
    long addDish(String name, String description, float price, boolean disabled, Date start_date, Date end_date, Time
            start_time, Time end_time);

    /**
     * Modify a dish's period info
     *
     * @param dish_id
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     */
    void setPeriodToDish(long dish_id, Date start_date, Date end_date, Time start_time, Time end_time);

    // TODO should we consider multiple case
    void setImagePath(String imagePath);

    // TODO also need to consider all its association

    /**
     * Remove a dish
     *
     * @param dishName
     * @return
     */
    boolean removeDish(String dishName);

}
