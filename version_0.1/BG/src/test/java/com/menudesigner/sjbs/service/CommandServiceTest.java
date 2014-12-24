package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.domain.CommandDish;
import com.menudesigner.sjbs.service.repository.CommandDishRepository;
import com.menudesigner.sjbs.service.repository.CommandRepository;
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

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by JIN Benli on 22/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class CommandServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(CommandServiceTest.class);

    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private CommandService commandService;
    @Autowired
    private DishService dishService;
    @Autowired
    private CommandDishRepository commandDishRepository;

    @Test
    public void addDishToCommandTest() {

//        Dish newDish = new Dish();
//        newDish.setName("coca");
//        newDish.setIs_typed(false);
//        newDish.setImg_path("abc");
//        newDish.setPrice(5);
//        newDish.setDescription("abc");
//        newDish.setDisabled(false);
//        newDish.setStart_time(new Time(10, 10, 10));
//        newDish.setEnd_time(new Time(10, 11, 10));
//        newDish.setStart_date(new Date(2014, 10, 12));
//        newDish.setEnd_date(new Date(2014, 11, 12));


        long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12), new Time(10, 10, 10), new Time(10, 11, 10));
        long command_id = commandService.addCommand("Bob", "test", 1, 5);

        boolean res = commandService.addDishToCommand(dish_id, command_id, 2);

        List<CommandDish> commandDishs = commandDishRepository.findCommandDishByCommandAndDish(commandRepository.findOne(command_id), dishRepository.findOne(dish_id));

        assertThat(dish_id, not(-1L));
        assertThat(command_id, not(-1L));
        assertTrue(res);
        assertThat(commandDishs.size(), is(1));
        assertThat(commandDishs.get(0).getQuantity() == 2, is(Boolean.TRUE));
    }
}
