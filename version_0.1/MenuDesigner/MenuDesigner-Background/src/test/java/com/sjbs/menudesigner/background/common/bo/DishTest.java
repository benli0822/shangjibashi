package com.sjbs.menudesigner.background.common.bo;

import com.sjbs.menudesigner.background.Application;
import com.sjbs.menudesigner.background.common.dao.DishRepository;
import com.sjbs.menudesigner.background.common.dao.OptionRepository;
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

  @Autowired
  private OptionRepository optionRepository;

  @Test
  public void addSimpleDishTest() {

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
    newDish.setPrice(5f);
    newDish.setDescription("abc");
    newDish.setDisabled(false);
    newDish.setStart_time(new Time(19, 10, 10));
    newDish.setEnd_time(new Time(19, 11, 10));
    newDish.setStart_date(new Date(2014, 9, 10));
    newDish.setEnd_date(new Date(2014, 10, 10));

    Dish res1 = dishRepository.save(newDish);
    dishRepository.delete(res1);

    Dish res2 = dishRepository.findOne(res1.getId());

    assertThat(res1, notNullValue());
    assertThat(res2, nullValue());
  }

  @Test
  public void addDishWithOptionTest() {
    Dish newDish = new Dish();
    newDish.setName("coca");
    newDish.setIs_typed(false);
    newDish.setPrice(5f);
    newDish.setDescription("abc");
    newDish.setDisabled(false);
    newDish.setStart_time(new Time(19, 10, 10));
    newDish.setEnd_time(new Time(19, 11, 10));
    newDish.setStart_date(new Date(2014, 9, 10));
    newDish.setEnd_date(new Date(2014, 10, 10));

    Option option = new Option();
    option.setName("test");

    Dish res1 = dishRepository.save(newDish);
    Option res2 = optionRepository.save(option);

    option.addDish(newDish);
//        newDish.addOption(option);

    assertThat(res1, notNullValue());
    assertThat(res2, notNullValue());

    assertThat(res1.getOptions().contains(res2), is(Boolean.TRUE));
    assertThat(res2.getDishes().contains(res1), is(Boolean.TRUE));
  }
}
