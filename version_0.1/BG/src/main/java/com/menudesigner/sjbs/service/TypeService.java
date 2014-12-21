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
     * @param dish
     * @param type_id
     * @return
     */
    boolean addTypeToDish(Dish dish, long type_id);

}
