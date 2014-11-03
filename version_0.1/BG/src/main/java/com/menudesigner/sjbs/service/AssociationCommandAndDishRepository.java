package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.AssociationCommandAndDish;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface AssociationCommandAndDishRepository {

    List<AssociationCommandAndDish> findByDishId(Integer dish_id);

    List<AssociationCommandAndDish> findByCommandId(Integer command_id);

    List<AssociationCommandAndDish> findByDishIdAndCommandID(Integer dish_id, Integer command_id);
}
