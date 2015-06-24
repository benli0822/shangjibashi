package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.domain.Activity;
import com.menudesigner.sjbs.domain.ActivityDish;
import com.menudesigner.sjbs.service.repository.ActivityDishRepository;
import com.menudesigner.sjbs.service.repository.ActivityRepository;
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
import static org.junit.Assert.assertTrue;

/**
 * Created by JIN Benli on 23/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class ActivityServiceTest {
  private static final Logger logger = LoggerFactory.getLogger(ActivityServiceTest.class);

  @Autowired
  private ActivityRepository activityRepository;

  @Autowired
  private DishRepository dishRepository;

  @Autowired
  private ActivityDishRepository activityDishRepository;

  @Autowired
  private ActivityService activityService;

  @Autowired
  private DishService dishService;

  @Test
  public void addActivityWithoutPeriodTest() {
    long activity_id = activityService.addActivity("noel", "noel");

    Activity activity = activityRepository.findOne(activity_id);

    assertThat(activity_id, notNullValue());
    assertThat(activity, notNullValue());

    assertThat(activity.getName(), is("noel"));
    assertThat(activity.getDescription(), is("noel"));
  }

  @Test
  public void addActivityWithPeriodTest() {
    long activity_id = activityService.addActivity("noel", "noel", new Date(2014, 12, 24), new Date(2014, 12, 25)
        , new Time(8, 20, 00), new Time(20, 20, 00));

    Activity activity = activityRepository.findOne(activity_id);

    assertThat(activity_id, notNullValue());
    assertThat(activity, notNullValue());

    assertThat(activity.getName(), is("noel"));
    assertThat(activity.getDescription(), is("noel"));

    assertThat(activity.getStart_date(), is(new Date(2014, 12, 24)));
    assertThat(activity.getEnd_date(), is(new Date(2014, 12, 25)));
    assertThat(activity.getStart_time(), is(new Time(8, 20, 00)));
    assertThat(activity.getEnd_time(), is(new Time(20, 20, 00)));
  }

  @Test
  public void addDishToActivityTest() {

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
//
//        Dish theDish = dishRepository.save(newDish);

    long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12),
        new Time(10, 10, 10), new Time(10, 11, 10));
    long activity_id = activityService.addActivity("noel", "noel");

    boolean res = activityService.addDishToActivity(dish_id, activity_id, 2);

    List<ActivityDish> activityDishs = activityDishRepository.findActivityDishByActivityAndDish
        (activityRepository.findOne(activity_id), dishRepository.findOne(dish_id));

    assertThat(dish_id, not(-1L));
    assertThat(activity_id, not(-1L));
    assertTrue(res);
    assertThat(activityDishs.size(), is(1));
    assertThat(activityDishs.get(0).getQuantity() == 2, is(Boolean.TRUE));
  }

  @Test
  public void removeDishFromActivityTest() {
    long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12),
        new Time(10, 10, 10), new Time(10, 11, 10));
    long activity_id = activityService.addActivity("noel", "noel");

    boolean res = activityService.addDishToActivity(dish_id, activity_id, 2);
    boolean res1 = activityService.removeDishFromActivity(dishRepository.findOne(dish_id));

    List<ActivityDish> activityDishs = activityDishRepository.findActivityDishByActivityAndDish
        (activityRepository.findOne(activity_id), dishRepository.findOne(dish_id));

    assertThat(dish_id, not(-1L));
    assertThat(activity_id, not(-1L));
    assertTrue(res);
    assertTrue(res1);
    assertThat(activityDishs.size(), is(0));
  }
}
