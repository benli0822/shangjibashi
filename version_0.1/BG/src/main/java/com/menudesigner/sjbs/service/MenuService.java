package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Menu;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface MenuService {

    long addMenu(Menu menu);

    long addMenu(String name, String description, Time start_time, Time end_time, Date start_date, Date end_date);

    long addMenu(String name, String description);

    boolean addDishToMenu(Dish dish, long menu_id);

    boolean removeMenu();
}
