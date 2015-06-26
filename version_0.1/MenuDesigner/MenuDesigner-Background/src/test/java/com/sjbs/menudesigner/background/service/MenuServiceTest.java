package com.sjbs.menudesigner.background.service;

import com.sjbs.menudesigner.background.Application;
import com.sjbs.menudesigner.background.domain.Menu;
import com.sjbs.menudesigner.background.domain.MenuDish;
import com.sjbs.menudesigner.background.service.repository.DishRepository;
import com.sjbs.menudesigner.background.service.repository.MenuDishRepository;
import com.sjbs.menudesigner.background.service.repository.MenuRepository;
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
 * Created by JIN Benli on 25/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class MenuServiceTest {
  private static final Logger logger = LoggerFactory.getLogger(MenuServiceTest.class);

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private DishRepository dishRepository;

  @Autowired
  private MenuDishRepository menuDishRepository;

  @Autowired
  private MenuService menuService;

  @Autowired
  private DishService dishService;

  @Test
  public void addMenuWithoutPeriodTest() {
    long menu_id = menuService.addMenu("noel", "noel");

    Menu menu = menuRepository.findOne(menu_id);

    assertThat(menu_id, notNullValue());
    assertThat(menu, notNullValue());
    assertThat(menu.getName(), is("noel"));
    assertThat(menu.getDescription(), is("noel"));
  }

  @Test
  public void addMenuWithPeriodTest() {
    long menu_id = menuService.addMenu("noel", "noel", new Date(2014, 12, 24), new Date(2014, 12, 25), new Time
        (8, 20, 00), new Time(20, 20, 00));

    Menu menu = menuRepository.findOne(menu_id);

    assertThat(menu_id, notNullValue());
    assertThat(menu, notNullValue());

    assertThat(menu.getName(), is("noel"));
    assertThat(menu.getDescription(), is("noel"));

    assertThat(menu.getStart_date(), is(new Date(2014, 12, 24)));
    assertThat(menu.getEnd_date(), is(new Date(2014, 12, 25)));
    assertThat(menu.getStart_time(), is(new Time(8, 20, 00)));
    assertThat(menu.getEnd_time(), is(new Time(20, 20, 00)));
  }

  @Test
  public void addDishToMenuTest() {
    long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12),
        new Time(10, 10, 10), new Time(10, 11, 10));
    long menu_id = menuService.addMenu("noel", "noel");

    boolean res = menuService.addDishToMenu(dish_id, menu_id, 2);

    List<MenuDish> menuDishs = menuDishRepository.findMenuDishByMenuAndDish(menuRepository.findOne(menu_id),
        dishRepository.findOne(dish_id));

    assertThat(dish_id, not(-1L));
    assertThat(menu_id, not(-1L));
    assertTrue(res);
    assertThat(menuDishs.size(), is(1));
    assertThat(menuDishs.get(0).getQuantity() == 2, is(Boolean.TRUE));
  }

  @Test
  public void removeDishFromMenuTest() {
    long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12),
        new Time(10, 10, 10), new Time(10, 11, 10));
    long menu_id = menuService.addMenu("noel", "noel");

    boolean res = menuService.addDishToMenu(dish_id, menu_id, 2);

    boolean res1 = menuService.removeDishFromMenu(dishRepository.findOne(dish_id));

    List<MenuDish> menuDishs = menuDishRepository.findMenuDishByMenuAndDish(menuRepository.findOne(menu_id),
        dishRepository.findOne(dish_id));

    assertThat(dish_id, not(-1L));
    assertThat(menu_id, not(-1L));
    assertTrue(res);
    assertTrue(res1);
    assertThat(menuDishs.size(), is(0));
  }
}
