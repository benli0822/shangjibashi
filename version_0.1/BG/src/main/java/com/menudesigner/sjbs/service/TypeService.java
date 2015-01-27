package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Type;

/**
 * Created by JIN Benli on 21/12/14.
 */
public interface TypeService {
    /**
     * Make sure this is the unique type created in repository
     * @param type
     * @return
     */
    long createType(Type type);

    /**
     * This is where we create a basic type
     * @param is_firstmenu
     * @param is_secondmenu
     * @param firstmenu_id
     * @param name
     * @param description
     * @param is_for_customize
     * @return
     */
    long createType(boolean is_firstmenu, boolean is_secondmenu, long firstmenu_id, String name, String description, boolean is_for_customize);

    /**
     * Add a type to dish
     * @param dish_id
     * @param type_id
     * @return
     */
    boolean addTypeToDish(long dish_id, long type_id);

    /**
     * Add a conflict type to type
     * @param type_id
     * @param conflict_type_id
     * @return
     */
    boolean addConflictToType(long type_id, long conflict_type_id);

    /**
     * Remove the dish from existing types
     * @param dish
     * @return
     */
    boolean removeDishFromType(Dish dish);

    // TODO Customize type operation
}
