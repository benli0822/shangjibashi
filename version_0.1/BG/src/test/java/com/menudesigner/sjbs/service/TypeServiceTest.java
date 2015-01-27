package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Type;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.TypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 25/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class TypeServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(TypeServiceTest.class);

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private TypeService typeService;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishService dishService;

    @Test
    public void createTypeTest() {
        logger.debug("Create Type Test");

        long type_id = typeService.createType(true, false, -1L, "hottest", "hottest", false);

        Type type = typeRepository.findOne(type_id);

        assertThat(type_id, notNullValue());
        assertThat(type, notNullValue());

        assertThat(type.isIs_firstmenu(), is(Boolean.TRUE));
        assertThat(type.isIs_secondmenu(), is(Boolean.FALSE));
        assertThat(type.getFirstmenu_id(), is(-1L));
        assertThat(type.getName(), is("hottest"));
        assertThat(type.getDescription(), is("hottest"));
        assertThat(type.isIs_for_customize(), is(false));
    }

    @Test
    public void addDishToTypeTest() {
        logger.debug("Add dish to type test");

        long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12), new Time(10, 10, 10), new Time(10, 11, 10));
        long type_id = typeService.createType(true, false, -1L, "hottest", "hottest", false);

        boolean res = typeService.addTypeToDish(dish_id, type_id);

        Type type = typeRepository.findOne(type_id);
        Dish dish = dishRepository.findOne(dish_id);

        assertThat(dish_id > 0L, is(true));
        assertThat(type_id > 0L, is(true));

        assertThat(res, is(Boolean.TRUE));

        assertThat(type.getDishes().contains(dish), is(Boolean.TRUE));
        assertThat(dish.getTypes().contains(type), is(Boolean.TRUE));
    }

    @Test
    public void addConflictTypeTest() {
        logger.debug("Testing conflict type");

        long type_id1 = typeService.createType(true, false, -1L, "hottest", "hottest", false);
        long type_id2 = typeService.createType(true, false, -1L, "coldtest", "coldtest", false);

        boolean res = typeService.addConflictToType(type_id1, type_id2);

        Type type1 = typeRepository.findOne(type_id1);
        Type type2 = typeRepository.findOne(type_id2);

        assertThat(type_id1, notNullValue());
        assertThat(type_id2, notNullValue());

        assertThat(type1, notNullValue());
        assertThat(type2, notNullValue());

        assertThat(res, is(Boolean.TRUE));

        assertThat(type1.getConflictTypes().contains(type2), is(Boolean.TRUE));
        assertThat(type2.getConflictTypes().contains(type1), is(Boolean.TRUE));
        // TODO need to test with database
    }

    @Test
    public void removeDishFromTypeTest() {
        logger.debug("Add dish to type test");

        long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12), new Time(10, 10, 10), new Time(10, 11, 10));
        long type_id = typeService.createType(true, false, -1L, "hottest", "hottest", false);

        boolean res = typeService.addTypeToDish(dish_id, type_id);


        Type type = typeRepository.findOne(type_id);
        Dish dish = dishRepository.findOne(dish_id);

        boolean res1 = typeService.removeDishFromType(dish);

        assertThat(dish_id > 0L, is(true));
        assertThat(type_id > 0L, is(true));

        assertThat(res, is(Boolean.TRUE));
        assertThat(res1, is(Boolean.TRUE));

        assertThat(type.getDishes().contains(dish), is(Boolean.FALSE));
        assertThat(dish.getTypes().contains(type), is(Boolean.FALSE));
    }
}
