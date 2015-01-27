package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Option;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.OptionRepository;
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
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 27/01/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class OptionServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(OptionServiceTest.class);

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private OptionService optionService;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishService dishService;

    @Test
    public void removeDishFromOptionTest() {
        logger.debug("remove dish from option test");

        long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12), new Time(10, 10, 10), new Time(10, 11, 10));
        long option_id = optionService.addOption("test");

        boolean res = optionService.addOptionToDish(dish_id, option_id);

        Option option = optionRepository.findOne(option_id);
        Dish dish = dishRepository.findOne(dish_id);

        boolean res1 = optionService.removeDishFromOption(dish);

        assertThat(dish_id > 0L, is(true));
        assertThat(option_id > 0L, is(true));

        assertThat(res, is(Boolean.TRUE));
        assertThat(res1, is(Boolean.TRUE));

        assertThat(option.getDishes().contains(dish), is(Boolean.FALSE));
        assertThat(dish.getOptions().contains(option), is(Boolean.FALSE));
    }

}
