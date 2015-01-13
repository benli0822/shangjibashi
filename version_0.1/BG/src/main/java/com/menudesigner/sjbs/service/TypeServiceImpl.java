package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Type;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JIN Benli on 21/12/14.
 */
@Service
@Component("typeService")
@Transactional
public class TypeServiceImpl implements TypeService {
    private static final Logger logger = LoggerFactory.getLogger(TypeServiceImpl.class);

    private final TypeRepository typeRepository;
    private final DishRepository dishRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository, DishRepository dishRepository) {
        this.typeRepository = typeRepository;
        this.dishRepository = dishRepository;
    }

    /**
     * Only unique type can be created in repository
     *
     * @param type
     * @return
     */
    @Override
    public long createType(Type type) {
        logger.debug("Try adding type: " + type.toString());

        //TODO create dish with params
        if (typeRepository.findTypeByName(type.getName()).size() == 0) {
            Type theType = typeRepository.save(type);
            logger.info("Type " + type.toString() + " added!");
            return theType.getId();
        } else {
            logger.error("Type " + type.toString() + " existed!");
            return -1L;
        }
    }

    /**
     * Create a simple type object
     *
     * @param is_firstmenu
     * @param is_secondmenu
     * @param firstmenu_id
     * @param name
     * @param description
     * @param is_for_customize
     * @return
     */
    @Override
    public long createType(boolean is_firstmenu, boolean is_secondmenu, long firstmenu_id, String name, String description, boolean is_for_customize) {
        logger.debug("Try adding type");
        Type type = new Type();

        assert is_firstmenu != is_secondmenu;

        type.setIs_firstmenu(is_firstmenu);
        type.setIs_secondmenu(is_secondmenu);
        type.setFirstmenu_id(firstmenu_id);
        type.setName(name);
        type.setDescription(description);
        type.setIs_for_customize(is_for_customize);

        return this.createType(type);
    }

    /**
     * Only unique type association can exist between dish and type
     *
     * @param dish_id
     * @param type_id
     * @return
     */
    @Override
    public boolean addTypeToDish(long dish_id, long type_id) {
        Dish dish = dishRepository.findOne(dish_id);
        Type type = typeRepository.findOne(type_id);

        //TODO all should be added with all type for test use
        List<Type> allData = typeRepository.findTypeByName("all_data");

        logger.info(dish.toString());
        logger.info(type.toString());
        assert dish != null;
        assert type != null;
        if (dish.getTypes().contains(type) && type.getDishes().contains(dish)) {
            logger.info("Type " + type.toString() + " existed in dish " + dish.toString());
            return false;
        } else {
            logger.info("Type " + type.toString() + " added to dish " + dish.toString());
//            dish.addType(type);
            type.addDish(dish);

            for(Type t : allData) {
                t.addDish(dish);
            }

            // TODO should verify if here truly needed or not
//            typeRepository.save(type);
            return true;
        }
    }

    /**
     * Only unique type association can exist between type and its conflict type
     * @param type_id
     * @param conflict_type_id
     * @return
     */
    @Override
    public boolean addConflictToType(long type_id, long conflict_type_id) {
        Type type = typeRepository.findOne(type_id);
        Type conflict_type = typeRepository.findOne(conflict_type_id);

        if (type.getConflictTypes().contains(conflict_type) && conflict_type.getConflictTypes().contains(type)) {
            logger.info("Type " + type.toString() + " already is conflict type to type " + conflict_type.toString());
            return false;
        } else {
            logger.info("Type " + type.toString() + " added as conflict type to type " + conflict_type.toString());
            type.addConflictType(conflict_type);
            conflict_type.addConflictType(type);
            return true;
        }
    }
}
