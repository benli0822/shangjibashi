package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Option;

/**
 * Created by JIN Benli on 13/01/15.
 */
public interface OptionService
{

    long addOption(Option option);

    long addOption(String name);

    boolean addOptionToDish(long dish_id, long option_id);

    boolean removeOption(String name);

    boolean removeDishFromOption(Dish dish);
}
