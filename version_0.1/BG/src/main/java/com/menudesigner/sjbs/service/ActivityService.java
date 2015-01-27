package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Activity;
import com.menudesigner.sjbs.domain.Dish;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by JIN Benli on 17/12/14.
 */
public interface ActivityService {
    /**
     * Make sure that the activity added is unique
     * @param activity
     * @return
     */
    long addActivity(Activity activity);

    /**
     * This is where we create the basic activity object
     * @param name
     * @param description
     * @return
     */
    long addActivity(String name, String description);

    /**
     * This is where we create the basic activity object with period
     * @param name
     * @param description
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     * @return
     */
    long addActivity(String name, String description, Date start_date, Date end_date, Time start_time, Time end_time);

    /**
     * Depends on modification, this function will be called as needed
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     */
    void setPeriodToActivity(long activity_id, Date start_date, Date end_date, Time start_time, Time end_time);

    /**
     * Add an existed dish to activity
     * @param dish_id
     * @param activity_id
     * @param quantity
     * @return
     */
    boolean addDishToActivity(long dish_id, long activity_id, int quantity);

    //TODO need to verify menu and activity

    boolean removeActivity(String name);

    /**
     * Remove the given dish from activity
     * @param dish
     * @return
     */
    boolean removeDishFromActivity(Dish dish);
}
