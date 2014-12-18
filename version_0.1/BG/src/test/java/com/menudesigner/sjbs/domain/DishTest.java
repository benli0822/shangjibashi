package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
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

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 10/11/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class DishTest {

    private static final Logger logger = LoggerFactory.getLogger(DishTest.class);

    @Autowired
    private DishRepository dishRepository;

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

        logger.info("[DishTest] addSimpleDishTest", newDish);

        Dish theDish = dishRepository.save(newDish);

        List<Dish> newAddedDish = dishRepository.findDishByName(newDish.getName());

        assertThat(theDish.getId(), notNullValue());
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

        Dish res1 = dishRepository.save(newDish);
        dishRepository.delete(res1);

        Dish res2 = dishRepository.findOne(res1.getId());

        assertThat(res1, notNullValue());
        assertThat(res2, nullValue());
    }


}
