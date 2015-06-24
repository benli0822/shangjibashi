package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Activity;
import com.menudesigner.sjbs.domain.ActivityDish;
import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.service.repository.ActivityDishRepository;
import com.menudesigner.sjbs.service.repository.ActivityRepository;
import com.menudesigner.sjbs.service.repository.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;


/**
 * Created by JIN Benli on 17/12/14.
 */
@Service
@Component("activityService")
@Transactional
public class ActivityServiceImpl implements ActivityService {
  private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

  private final ActivityRepository activityRepository;
  private final DishRepository dishRepository;
  private final ActivityDishRepository activityDishRepository;

  @Autowired
  public ActivityServiceImpl(ActivityRepository activityRepository, DishRepository dishRepository,
                             ActivityDishRepository activityDishRepository) {
    this.activityRepository = activityRepository;
    this.dishRepository = dishRepository;
    this.activityDishRepository = activityDishRepository;
  }

  @Override
  public long addActivity(Activity activity) {
    logger.debug("Try adding activity: " + activity.toString());
    if (activityRepository.findActivityByName(activity.getName()).size() == 0) {
      Activity theActivity = activityRepository.save(activity);
      logger.info("Activity " + activity.toString() + " added!");
      return theActivity.getId();
    } else {
      logger.error("Activity " + activity.toString() + " existed!");
      return -1L;
    }
  }

  @Override
  public long addActivity(String name, String description) {
    logger.debug("Try adding activity");

    Activity activity = new Activity();

    activity.setName(name);
    activity.setDescription(description);

    return this.addActivity(activity);
  }

  @Override
  public long addActivity(String name, String description, Date start_date, Date end_date, Time start_time, Time
      end_time) {
    logger.debug("Try adding activity");

    long activity_id = this.addActivity(name, description);

    this.setPeriodToActivity(activity_id, start_date, end_date, start_time, end_time);

    return activity_id;
  }

  @Override
  public void setPeriodToActivity(long activity_id, Date start_date, Date end_date, Time start_time, Time end_time) {
    Activity theActivity = activityRepository.findOne(activity_id);

    theActivity.setStart_date(start_date);
    theActivity.setEnd_date(end_date);
    theActivity.setStart_time(start_time);
    theActivity.setEnd_time(end_time);

    activityRepository.save(theActivity);
  }

  @Override
  public boolean addDishToActivity(long dish_id, long activity_id, int quantity) {
    logger.debug("Try adding dish to activity");
    Dish theDish = dishRepository.findOne(dish_id);
    Activity theActivity = activityRepository.findOne(activity_id);

    logger.debug("Dish " + theDish.toString() + " Activity " + theActivity.toString() + " with quantity: " +
        quantity);

    // first check the association
    List<ActivityDish> associations = activityDishRepository.findActivityDishByActivityAndDish(theActivity,
        theDish);

    if (associations.size() == 0) {
      // if neither activity nor dish has been added to each other, the add the association
      theActivity.addDish(theDish, quantity);

      return true;
    } else if (associations.size() == 1) {
      associations.get(0).setQuantity(quantity);

      return true;
    } else {
      logger.error("neither dish " + theDish.toString() + "nor activity " + theActivity.toString() + "has " +
          "already associated with each other more than one time!");
      return false;
    }
  }

  @Override
  public boolean removeActivity(String name) {
    logger.debug("Removing activity name " + name);

    List<Activity> activities = activityRepository.findActivityByName(name);

    if (activities.size() == 0) {
      logger.debug("Activity not found!");
      return false;
    }

    for (Activity a : activities) {
      logger.debug("Removing activity " + a.toString());
      activityRepository.delete(a);
    }

    logger.debug("Remove finish");
    return true;
  }

  @Override
  public boolean removeDishFromActivity(Dish dish) {
    assert dishRepository.exists(dish.getId());

    Set<ActivityDish> activityDishs = dish.getActivities();

    for (ActivityDish ad : activityDishs) {
      Activity a = ad.getActivity();
      a.getDishes().remove(ad);
      dish.getActivities().remove(ad);

      activityRepository.save(a);
      dishRepository.save(dish);
      activityDishRepository.delete(ad);
    }

    return true;
  }
}
