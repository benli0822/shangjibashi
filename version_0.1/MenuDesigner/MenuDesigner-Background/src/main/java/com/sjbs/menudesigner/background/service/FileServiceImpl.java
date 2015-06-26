package com.sjbs.menudesigner.background.service;

import com.sjbs.menudesigner.background.common.bo.Activity;
import com.sjbs.menudesigner.background.common.bo.Dish;
import com.sjbs.menudesigner.background.common.bo.File;
import com.sjbs.menudesigner.background.common.bo.Menu;
import com.sjbs.menudesigner.background.common.dao.ActivityRepository;
import com.sjbs.menudesigner.background.common.dao.DishRepository;
import com.sjbs.menudesigner.background.common.dao.FileRepository;
import com.sjbs.menudesigner.background.common.dao.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by JIN Benli on 28/12/14.
 */
@Service
@Component("fileService")
@Transactional
public class FileServiceImpl implements FileService {

  private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

  private final FileRepository fileRepository;
  private final DishRepository dishRepository;
  private final MenuRepository menuRepository;
  private final ActivityRepository activityRepository;

  @Autowired
  public FileServiceImpl(FileRepository fileRepository, DishRepository dishRepository, MenuRepository
      menuRepository, ActivityRepository activityRepository) {
    this.fileRepository = fileRepository;
    this.dishRepository = dishRepository;
    this.menuRepository = menuRepository;
    this.activityRepository = activityRepository;
  }

  @Override
  public long saveFile(File file) {
    logger.debug("Try adding file: " + file.toString());

    // TODO should we consider the "file" object exception here? Other services have the same case
    if (fileRepository.findFileByName(file.getName()).size() == 0) {
      File theFile = fileRepository.save(file);
      logger.info("File " + file.toString() + " added!");
      return theFile.getId();
    } else {
      logger.error("File " + file.toString() + " existed!");
      return -1L;
    }
  }

  @Override
  public long saveFile(String name, String location, long size, String type) {
    logger.debug("Try adding file");
    File theFile = new File();
    theFile.setName(name);
    theFile.setLocation(location);
    theFile.setSize(size);
    theFile.setType(type);

    return this.saveFile(theFile);
  }

  @Override
  public boolean addFileToDish(long dish_id, long file_id) {
    logger.debug("Try adding file to dish");
    File theFile = fileRepository.findOne(file_id);
    Dish theDish = dishRepository.findOne(dish_id);

    logger.debug("File " + theFile.toString() + " Dish " + theDish.toString());

    assert theFile != null;
    assert theDish != null;
    // first check the association
    if (!theFile.getDishes().contains(theDish)) {
      theFile.addDish(theDish);
      return true;
    } else {
      logger.error("neither dish " + theDish.toString() + "nor file " + theFile.toString() + "has already " +
          "associated with each other more than one time!");
      return false;
    }
  }

  @Override
  public boolean addFileToMenu(long menu_id, long file_id) {
    logger.debug("Try adding file to menu");
    File theFile = fileRepository.findOne(file_id);
    Menu theMenu = menuRepository.findOne(menu_id);

    logger.debug("File " + theFile.toString() + " Menu " + theMenu.toString());

    // first check the association
    if (!theFile.getMenus().contains(theMenu)) {
      theFile.addMenu(theMenu);
      return true;
    } else {
      logger.error("neither menu " + theMenu.toString() + "nor file " + theFile.toString() + "has already " +
          "associated with each other more than one time!");
      return false;
    }
  }

  @Override
  public boolean addFileToActivity(long activity_id, long file_id) {
    logger.debug("Try adding file to activity");
    File theFile = fileRepository.findOne(file_id);
    Activity theActivity = activityRepository.findOne(activity_id);

    logger.debug("File " + theFile.toString() + " Activity " + theActivity.toString());

    // first check the association
    if (!theFile.getActivities().contains(theActivity)) {
      theFile.addActivity(theActivity);
      return true;
    } else {
      logger.error("neither activity " + theActivity.toString() + "nor file " + theFile.toString() + "has " +
          "already associated with each other more than one time!");
      return false;
    }
  }

  @Override
  public boolean removeFile(String fileName) {
    logger.debug("Removing file name " + fileName);

    List<File> fileList = fileRepository.findFileByName(fileName);

    if (fileList.size() == 0) {
      logger.debug("File not found!");
      return false;
    }


    for (File f : fileList) {
      // first remove all connections
      Set<Dish> dishSet = f.getDishes();
      for (Dish d : dishSet) {
        f.removeDish(d);
        logger.debug("Removing dish " + d.toString() + " in file" + f.toString());
      }
      Set<Menu> menuSet = f.getMenus();
      for (Menu m : menuSet) {
        f.removeMenu(m);
        logger.debug("Removing menu " + m.toString() + " in file" + f.toString());
      }
      Set<Activity> activitySet = f.getActivities();
      for (Activity a : activitySet) {
        f.removeActivity(a);
        logger.debug("Removing activity " + a.toString() + " in file" + f.toString());
      }
      logger.debug("Removing file " + f.toString());
      fileRepository.delete(f);
    }

    logger.debug("Remove finish");
    return true;
  }
}
