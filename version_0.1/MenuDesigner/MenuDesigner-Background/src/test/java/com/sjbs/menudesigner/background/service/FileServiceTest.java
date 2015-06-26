package com.sjbs.menudesigner.background.service;

import com.sjbs.menudesigner.background.Application;
import com.sjbs.menudesigner.background.domain.Activity;
import com.sjbs.menudesigner.background.domain.Dish;
import com.sjbs.menudesigner.background.domain.File;
import com.sjbs.menudesigner.background.domain.Menu;
import com.sjbs.menudesigner.background.service.repository.ActivityRepository;
import com.sjbs.menudesigner.background.service.repository.DishRepository;
import com.sjbs.menudesigner.background.service.repository.FileRepository;
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

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 28/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class FileServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(FileServiceTest.class);

  @Autowired
  private FileRepository fileRepository;

  @Autowired
  private FileService fileService;

  @Autowired
  private DishService dishService;

  @Autowired
  private MenuService menuService;

  @Autowired
  private ActivityService activityService;

  @Autowired
  private DishRepository dishRepository;

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private ActivityRepository activityRepository;

  @Test
  public void addSimpleFileTest() {
    long file_id = fileService.saveFile("test", "test", 20L, "media");

    File file = fileRepository.findOne(file_id);

    assertThat(file_id, notNullValue());
    assertThat(file, notNullValue());

    assertThat(file.getName(), is("test"));
    assertThat(file.getLocation(), is("test"));
    assertThat(file.getSize(), is(20L));
    assertThat(file.getType(), is("media"));
  }

  @Test
  public void removeSimpleFileTest() {
    long file_id = fileService.saveFile("test", "test", 20L, "media");

    File file = fileRepository.findOne(file_id);

    boolean res = fileService.removeFile(file.getName());

    File res1 = fileRepository.findOne(file_id);

    assertThat(file_id, notNullValue());
    assertThat(file, notNullValue());

    assertThat(file.getName(), is("test"));
    assertThat(file.getLocation(), is("test"));
    assertThat(file.getSize(), is(20L));
    assertThat(file.getType(), is("media"));

    assertThat(res, is(Boolean.TRUE));
    assertThat(res1, nullValue());
  }

  @Test
  public void addFileToDishTest() {
    long dish_id = dishService.addDish("coca", "abc", 5, false, new Date(2014, 10, 12), new Date(2014, 11, 12),
        new Time(10, 10, 10), new Time(10, 11, 10));

    long file_id = fileService.saveFile("test", "test", 20L, "media");

    boolean res = fileService.addFileToDish(dish_id, file_id);

    Dish res1 = dishRepository.findOne(dish_id);

    File res2 = fileRepository.findOne(file_id);

    assertThat(dish_id, notNullValue());
    assertThat(file_id, notNullValue());

    assertThat(res, is(Boolean.TRUE));

    assertThat(res1, notNullValue());
    assertThat(res2, notNullValue());

    assertThat(res1.getFiles().contains(res2), is(Boolean.TRUE));
    assertThat(res2.getDishes().contains(res1), is(Boolean.TRUE));
  }

  @Test
  public void addFileToMenuTest() {
    long menu_id = menuService.addMenu("noel", "noel");

    long file_id = fileService.saveFile("test", "test", 20L, "media");

    boolean res = fileService.addFileToMenu(menu_id, file_id);

    Menu res1 = menuRepository.findOne(menu_id);

    File res2 = fileRepository.findOne(file_id);

    assertThat(menu_id, notNullValue());
    assertThat(file_id, notNullValue());

    assertThat(res, is(Boolean.TRUE));

    assertThat(res1, notNullValue());
    assertThat(res2, notNullValue());

    assertThat(res1.getFiles().contains(res2), is(Boolean.TRUE));
    assertThat(res2.getMenus().contains(res1), is(Boolean.TRUE));
  }

  @Test
  public void addFileToActivityTest() {
    long activity_id = activityService.addActivity("noel", "noel");

    long file_id = fileService.saveFile("test", "test", 20L, "media");

    boolean res = fileService.addFileToActivity(activity_id, file_id);

    Activity res1 = activityRepository.findOne(activity_id);

    File res2 = fileRepository.findOne(file_id);

    assertThat(activity_id, notNullValue());
    assertThat(file_id, notNullValue());

    assertThat(res, is(Boolean.TRUE));

    assertThat(res1, notNullValue());
    assertThat(res2, notNullValue());

    assertThat(res1.getFiles().contains(res2), is(Boolean.TRUE));
    assertThat(res2.getActivities().contains(res1), is(Boolean.TRUE));
  }


}
