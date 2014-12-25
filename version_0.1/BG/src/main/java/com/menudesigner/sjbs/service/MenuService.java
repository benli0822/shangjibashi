package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Menu;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface MenuService {

    /**
     * Create a unique menu entity and store it in repository
     *
     * @param menu
     * @return
     */
    long addMenu(Menu menu);

    /**
     * This is where we create a basic object
     *
     * @param name
     * @param description
     * @return
     */
    long addMenu(String name, String description);

    /**
     * This is where we create a basic object with period
     *
     * @param name
     * @param description
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     * @return
     */
    long addMenu(String name, String description, Date start_date, Date end_date, Time start_time, Time end_time);

    /**
     * Modify the menu's period attribute
     * @param menu_id
     * @param start_date
     * @param end_date
     * @param start_time
     * @param end_time
     */
    void setPeriodToMenu(long menu_id, Date start_date, Date end_date, Time start_time, Time end_time);

    /**
     * Adding a dish to menu
     * @param dish_id
     * @param menu_id
     * @return
     */
    boolean addDishToMenu(long dish_id, long menu_id, int quantity);

    /**
     * Remove a menu by name
     * @param name
     * @return
     */
    boolean removeMenu(String name);
}
