package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.service.DishService;
import com.menudesigner.sjbs.service.repository.DishRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 10/11/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class DishServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(DishServiceTest.class);

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishService dishService;

    @Test
    public void addSimpleDishTest() {

        Dish newDish = new Dish();
        newDish.setName("coca");
        newDish.setIs_typed(false);
        newDish.setImg_path("abc");
        newDish.setPrice(5);
        newDish.setDescription("abc");
        newDish.setDisabled(false);
        newDish.setStart_time(new Time(10,10,10));
        newDish.setEnd_time(new Time(10,11,10));
        newDish.setStart_date(new Date(2014,10,12));
        newDish.setEnd_date(new Date(2014,11,12));

        logger.info("[DishServiceTest] addDishTest", newDish);

        Boolean res = dishService.addDish(newDish);

        List<Dish> newAddedDish = dishRepository.findDishByName(newDish.getName());

        assertThat(res, is(Boolean.TRUE));
        assertThat(newAddedDish.size(), is(1));
        assertThat(newAddedDish.get(0).getName(), is(newDish.getName()));
    }

    @Test
    public void removeSimpleDishTest() {
        Dish newDish = new Dish();
        newDish.setName("coca");
        newDish.setIs_typed(false);
        newDish.setImg_path("abc");
        newDish.setPrice(5);
        newDish.setDescription("abc");
        newDish.setDisabled(false);
        newDish.setStart_time(new Time(19,10,10));
        newDish.setEnd_time(new Time(19,11,10));
        newDish.setStart_date(new Date(2014,9,10));
        newDish.setEnd_date(new Date(2014,10,10));

        Boolean res1 = dishService.addDish(newDish);
        Boolean res2 = dishService.removeDish(newDish.getName());

        assertThat(res1, is(Boolean.TRUE));
        assertThat(res2, is(Boolean.TRUE));
    }


}
