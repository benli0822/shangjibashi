package com.sjbs.menudesigner.background.domain;

import com.sjbs.menudesigner.background.Application;
import com.sjbs.menudesigner.background.service.repository.*;
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
public class CommandTest {

  private static final Logger logger = LoggerFactory.getLogger(CommandTest.class);

  @Autowired
  private CommandRepository commandRepository;

  @Autowired
  private ActivityRepository activityRepository;

  @Autowired
  private DishRepository dishRepository;

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private CommandDishRepository commandDishRepository;

  @Autowired
  private CommandActivityRepository commandActivityRepository;

  @Autowired
  private CommandMenuRepository commandMenuRepository;

  @Test
  public void addSimpleCommandTest() {
    Command command = new Command();

    command.setTitle("Bob");
    command.setMsg_extra("test");
    command.setOrder_date(new Date(2014, 10, 12));
    command.setOrder_time(new Time(20, 20, 20));
    command.setTable_no(1);
    command.setClient_no(5);

    logger.info("[CommandTest] addSimpleCommandTest", command);

    Command theCommand = commandRepository.save(command);

    assertThat(theCommand.getId(), notNullValue());

  }

  @Test
  public void removeSimpleCommandTest() {
    Command command = new Command();

    command.setTitle("Bob");
    command.setMsg_extra("test");
    command.setOrder_date(new Date(2014, 10, 12));
    command.setOrder_time(new Time(20, 20, 20));
    command.setTable_no(1);
    command.setClient_no(5);

    logger.info("[CommandTest] removeSimpleCommandTest", command);

    Command theCommand = commandRepository.save(command);
    commandRepository.delete(theCommand);

    Command theRes = commandRepository.findOne(theCommand.getId());

    assertThat(theCommand, notNullValue());
    assertThat(theRes, nullValue());

  }

  @Test
  public void addCommandWithActivityTest() {
    Command command = new Command();

    command.setTitle("Bob");
    command.setMsg_extra("test");
    command.setOrder_date(new Date(2014, 10, 12));
    command.setOrder_time(new Time(20, 20, 20));
    command.setTable_no(1);
    command.setClient_no(5);

    Activity activity = new Activity();

    activity.setName("test");
    activity.setDescription("test");
    activity.setStart_date(new Date(2014, 1, 2));
    activity.setEnd_date(new Date(2014, 1, 10));
    activity.setStart_time(new Time(19, 20, 55));
    activity.setEnd_time(new Time(19, 21, 55));

//        activity.addCommand(command);

    Command res1 = commandRepository.save(command);
    Activity res2 = activityRepository.save(activity);

    command.addActivity(activity, 2);

    List<CommandActivity> commandActivities = commandActivityRepository.findCommandActivityByCommandAndActivity
        (res1, res2);

    assertThat(res1, notNullValue());
    assertThat(res2, notNullValue());

    assertThat(commandActivities.size(), is(1));
    assertThat(commandActivities.get(0).getQuantity(), is(2));

    assertThat(res1.getActivities().contains(commandActivities.get(0)), is(Boolean.TRUE));
    assertThat(res2.getCommands().contains(commandActivities.get(0)), is(Boolean.TRUE));
  }

  @Test
  public void addCommandWithDishTest() {
    Command command = new Command();

    command.setTitle("Bob");
    command.setMsg_extra("test");
    command.setOrder_date(new Date(2014, 10, 12));
    command.setOrder_time(new Time(20, 20, 20));
    command.setTable_no(1);
    command.setClient_no(5);

    Dish newDish = new Dish();
    newDish.setName("coca");
    newDish.setIs_typed(false);
    newDish.setPrice(5f);
    newDish.setDescription("abc");
    newDish.setDisabled(false);
    newDish.setStart_time(new Time(10, 10, 10));
    newDish.setEnd_time(new Time(10, 11, 10));
    newDish.setStart_date(new Date(2014, 10, 12));
    newDish.setEnd_date(new Date(2014, 11, 12));

//        newDish.addCommand(command);

    Command res1 = commandRepository.save(command);
    Dish res2 = dishRepository.save(newDish);

    command.addDish(newDish, 2);

    List<CommandDish> commandDishes = commandDishRepository.findCommandDishByCommandAndDish(res1, res2);

    assertThat(res1, notNullValue());
    assertThat(res2, notNullValue());

    assertThat(commandDishes.size(), is(1));
    assertThat(commandDishes.get(0).getQuantity(), is(2));

    assertThat(res1.getDishes().contains(commandDishes.get(0)), is(Boolean.TRUE));
    assertThat(res2.getCommands().contains(commandDishes.get(0)), is(Boolean.TRUE));

  }

  @Test
  public void addCommandWithMenuTest() {
    Command command = new Command();

    command.setTitle("Bob");
    command.setMsg_extra("test");
    command.setOrder_date(new Date(2014, 10, 12));
    command.setOrder_time(new Time(20, 20, 20));
    command.setTable_no(1);
    command.setClient_no(5);

    Menu menu = new Menu();

    menu.setName("test");
    menu.setDescription("test");
    menu.setStart_date(new Date(2014, 10, 10));
    menu.setEnd_date(new Date(2014, 11, 10));
    menu.setStart_time(new Time(20, 19, 20));
    menu.setEnd_time(new Time(20, 20, 20));

//        menu.addCommand(command);

    Menu res1 = menuRepository.save(menu);
    Command res2 = commandRepository.save(command);

    command.addMenu(menu, 2);

    List<CommandMenu> commandMenus = commandMenuRepository.findCommandMenuByCommandAndMenu(res2, res1);

    assertThat(res1, notNullValue());
    assertThat(res2, notNullValue());

    assertThat(commandMenus.size(), is(1));
    assertThat(commandMenus.get(0).getQuantity(), is(2));

    assertThat(res1.getCommands().contains(commandMenus.get(0)), is(Boolean.TRUE));
    assertThat(res2.getMenus().contains(commandMenus.get(0)), is(Boolean.TRUE));
  }
}
