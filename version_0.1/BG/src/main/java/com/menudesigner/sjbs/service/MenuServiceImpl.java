package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Menu;
import com.menudesigner.sjbs.domain.MenuDish;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.MenuDishRepository;
import com.menudesigner.sjbs.service.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

/**
 * Created by JIN Benli on 24/12/14.
 */
@Service
@Component("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;
    private final MenuDishRepository menuDishRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, DishRepository dishRepository, MenuDishRepository menuDishRepository) {
        this.menuRepository = menuRepository;
        this.dishRepository = dishRepository;
        this.menuDishRepository = menuDishRepository;
    }

    @Override
    public long addMenu(Menu menu) {
        logger.debug("Try adding menu: " + menu.toString());
        if (menuRepository.findMenuByName(menu.getName()).size() == 0) {
            Menu theMenu = menuRepository.save(menu);
            logger.info("Menu " + menu.toString() + " added!");
            return theMenu.getId();
        } else {
            logger.error("Menu " + menu.toString() + " existed!");
            return -1L;
        }
    }

    @Override
    public long addMenu(String name, String description) {
        logger.debug("Try adding menu");

        Menu menu = new Menu();

        menu.setName(name);
        menu.setDescription(description);

        return this.addMenu(menu);
    }

    @Override
    public long addMenu(String name, String description, Date start_date, Date end_date, Time start_time, Time end_time) {
        logger.debug("Try adding menu");

        long menu_id = this.addMenu(name, description);

        this.setPeriodToMenu(menu_id, start_date, end_date, start_time, end_time);

        return menu_id;
    }

    @Override
    public void setPeriodToMenu(long menu_id, Date start_date, Date end_date, Time start_time, Time end_time) {
        Menu theMenu = menuRepository.findOne(menu_id);

        theMenu.setStart_date(start_date);
        theMenu.setEnd_date(end_date);
        theMenu.setStart_time(start_time);
        theMenu.setEnd_time(end_time);

        menuRepository.save(theMenu);
    }

    @Override
    public boolean addDishToMenu(long dish_id, long menu_id, int quantity) {
        logger.debug("Try adding dish to menu");
        Dish theDish = dishRepository.findOne(dish_id);
        Menu theMenu = menuRepository.findOne(menu_id);

        logger.debug("Dish " + theDish.toString() + " Menu " + theMenu.toString() + " with quantity " + quantity);

        // first check the association
        List<MenuDish> associations = menuDishRepository.findMenuDishByMenuAndDish(theMenu, theDish);

        if (associations.size() == 0) {
            // if neither activity nor dish has been added to each other, the add the association
            theMenu.addDish(theDish, quantity);

            return true;
        } else if (associations.size() == 1) {
            associations.get(0).setQuantity(quantity);

            return true;
        } else {
            logger.error("neither dish " + theDish.toString() + "nor menu " + theMenu.toString() + "has already associated with each other more than one time!");
            return false;
        }

    }

    @Override
    public boolean removeMenu(String name) {
        logger.debug("Removing menu name " + name);

        List<Menu> menus = menuRepository.findMenuByName(name);

        if (menus.size() == 0) {
            logger.debug("Menu not found!");
            return false;
        }

        for (Menu m : menus) {
            logger.debug("Removing menu " + m.toString());
            menuRepository.delete(m);
        }

        logger.debug("Remove finish");
        return true;
    }

    /**
     * Remove the given dish from menu
     *
     * @param dish
     * @return
     */
    @Override
    public boolean removeDishFromMenu(Dish dish) {
        assert dishRepository.exists(dish.getId());

        Set<MenuDish> menuDishs = (Set<MenuDish>) dish.getMenus();

        for(MenuDish md : menuDishs) {
            Menu m = md.getMenu();
            m.getDishes().remove(md);
            dish.getMenus().remove(md);

            menuRepository.save(m);
            dishRepository.save(dish);
            menuDishRepository.delete(md);
        }

        return true;
    }
}
