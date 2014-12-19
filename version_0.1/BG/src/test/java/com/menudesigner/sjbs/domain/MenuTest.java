package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.MenuRepository;
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

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 17/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class MenuTest {

    private static final Logger logger = LoggerFactory.getLogger(CommandTest.class);

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private DishRepository dishRepository;

    @Test
    public void addSimpleMenuTest() {
        Menu menu = new Menu();

        menu.setName("test");
        menu.setDescription("test");
        menu.setStart_date(new Date(2014, 10, 10));
        menu.setEnd_date(new Date(2014, 11 , 10));
        menu.setStart_time(new Time(20, 19, 20));
        menu.setEnd_time(new Time(20, 20, 20));

        logger.info("[CommandTest] addSimpleMenuTest", menu);

        Menu theMenu = menuRepository.save(menu);

        assertThat(theMenu, notNullValue());
    }

    @Test
    public void removeSimpleMenuTest() {
        Menu menu = new Menu();

        menu.setName("test");
        menu.setDescription("test");
        menu.setStart_date(new Date(2014, 10, 10));
        menu.setEnd_date(new Date(2014, 11 , 10));
        menu.setStart_time(new Time(20, 19, 20));
        menu.setEnd_time(new Time(20, 20, 20));

        logger.info("[CommandTest] removeSimpleMenuTest", menu);

        Menu theMenu = menuRepository.save(menu);
        menuRepository.delete(menu);
        Menu theRes = menuRepository.findOne(menu.getId());

        assertThat(theMenu, notNullValue());
        assertThat(theRes, nullValue());

    }

    @Test
    public void addMenuWithDishTest() {
        Menu menu = new Menu();

        menu.setName("test");
        menu.setDescription("test");
        menu.setStart_date(new Date(2014, 10, 10));
        menu.setEnd_date(new Date(2014, 11 , 10));
        menu.setStart_time(new Time(20, 19, 20));
        menu.setEnd_time(new Time(20, 20, 20));

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

        menu.addDish(newDish);
        newDish.addMenu(menu);

        Menu res1 = menuRepository.save(menu);
        Dish res2 = dishRepository.save(newDish);

        assertThat(res1, notNullValue());
        assertThat(res2, notNullValue());

        assertThat(res1.getDishes().contains(res2), is(Boolean.TRUE));
        assertThat(res2.getMenus().contains(res1), is(Boolean.TRUE));

    }
}
