package com.sjbs.menudesigner.background.service;

import com.sjbs.menudesigner.background.common.bo.Dish;
import com.sjbs.menudesigner.background.common.bo.Option;

/**
 * Created by JIN Benli on 13/01/15.
 */
public interface OptionService {

  long addOption(Option option);

  long addOption(String name);

  boolean addOptionToDish(long dish_id, long option_id);

  boolean removeOption(String name);

  boolean removeDishFromOption(Dish dish);
}
