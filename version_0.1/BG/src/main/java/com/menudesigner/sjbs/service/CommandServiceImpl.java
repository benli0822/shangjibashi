package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.*;
import com.menudesigner.sjbs.service.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Service
@Component("commandService")
@Transactional
public class CommandServiceImpl implements CommandService {
    private static final Logger logger = LoggerFactory.getLogger(CommandServiceImpl.class);

    private final CommandRepository commandRepository;
    private final DishRepository dishRepository;
    private final ActivityRepository activityRepository;
    private final MenuRepository menuRepository;
    private final CommandDishRepository commandDishRepository;
    private final CommandActivityRepository commandActivityRepository;
    private final CommandMenuRepository commandMenuRepository;

    @Autowired
    public CommandServiceImpl(CommandRepository commandRepository, DishRepository dishRepository, ActivityRepository activityRepository, MenuRepository menuRepository, CommandDishRepository commandDishRepository, CommandActivityRepository commandActivityRepository, CommandMenuRepository commandMenuRepository) {
        this.commandRepository = commandRepository;
        this.dishRepository = dishRepository;
        this.activityRepository = activityRepository;
        this.menuRepository = menuRepository;
        this.commandDishRepository = commandDishRepository;
        this.commandActivityRepository = commandActivityRepository;
        this.commandMenuRepository = commandMenuRepository;
    }

    @Override
    public long addCommand(Command command) {
        logger.debug("Try adding command: " + command.toString());

        if (commandRepository.findCommandByTitle(command.getTitle()).size() == 0) {
            Command theCommand = commandRepository.save(command);
            logger.info("Command " + command.toString() + " added!");
            return theCommand.getId();
        } else {
            logger.error("Command " + command.toString() + " existed!");
            return -1L;
        }
    }

    @Override
    public long addCommand(String title, String msg_extra, float price, int table_no, int client_no) {
        logger.debug("Try adding command");

        Command command = new Command();
        command.setTitle(title);
        command.setMsg_extra(msg_extra);
        command.setPrice(price);
        command.setTable_no(table_no);
        command.setClient_no(client_no);
        java.util.Date utilDate = new java.util.Date();
        command.setOrder_date(new Date(utilDate.getTime()));
        command.setOrder_time(new Time(utilDate.getTime()));

        return this.addCommand(command);
    }

    @Override
    public boolean addDishToCommand(long dish_id, long command_id, int quantity) {
        logger.debug("Try adding dish to command");
        Dish theDish = dishRepository.findOne(dish_id);
        Command theCommand = commandRepository.findOne(command_id);

        assert theDish != null;
        assert theCommand != null;

        logger.debug("Dish " + theDish.toString() + " Command " + theCommand.toString() + " with quantity: " + quantity);

        // first check the association
        List<CommandDish> associations = commandDishRepository.findCommandDishByCommandAndDish(theCommand, theDish);

        if (associations.size() == 0) {
            // if neither command nor dish has been added to each other, the add the association
            theCommand.addDish(theDish, quantity);

            return true;
        } else if (associations.size() == 1) {
            associations.get(0).setQuantity(quantity);

            return true;
        } else {
            logger.error("neither dish " + theDish.toString() + "nor command " + theCommand.toString() + "has already associated with each other more than one time!");
            return false;
        }
    }

    @Override
    public boolean addActivityToCommand(long activity_id, long command_id, int quantity) {
        logger.debug("Try adding activity to command");
        Activity theActivity = activityRepository.findOne(activity_id);
        Command theCommand = commandRepository.findOne(command_id);

        logger.debug("Activity " + theActivity.toString() + " Command " + theCommand.toString() + " with quantity: " + quantity);

        // first check the association
        List<CommandActivity> associations = commandActivityRepository.findCommandActivityByCommandAndActivity(theCommand, theActivity);

        if (associations.size() == 0) {
            // if neither command nor activity has been added to each other, the add the association
            theCommand.addActivity(theActivity, quantity);

            return true;
        } else if (associations.size() == 1) {
            associations.get(0).setQuantity(quantity);

            return true;
        } else {
            logger.error("neither activity " + theActivity.toString() + "nor command " + theCommand.toString() + "has already associated with each other more than one time!");
            return false;
        }
    }

    @Override
    public boolean addMenuToCommand(long menu_id, long command_id, int quantity) {
        logger.debug("Try adding menu to command");
        Menu theMenu = menuRepository.findOne(menu_id);
        Command theCommand = commandRepository.findOne(command_id);

        logger.debug("Menu " + theMenu.toString() + " Command " + theCommand.toString() + " with quantity: " + quantity);

        // first check the association
        List<CommandMenu> associations = commandMenuRepository.findCommandMenuByCommandAndMenu(theCommand, theMenu);

        if (associations.size() == 0) {
            // if neither command nor activity has been added to each other, the add the association
            theCommand.addMenu(theMenu, quantity);

            return true;
        } else if (associations.size() == 1) {
            associations.get(0).setQuantity(quantity);

            return true;
        } else {
            logger.error("neither menu " + theMenu.toString() + "nor command " + theCommand.toString() + "has already associated with each other more than one time!");
            return false;
        }
    }

    @Override
    public boolean removeCommand(String title) {
        logger.debug("Removing command title " + title);

        List<Command> commands = commandRepository.findCommandByTitle(title);

        if (commands.size() == 0) {
            logger.debug("Command not found!");
            return false;
        }

        for (Command c : commands) {
            logger.debug("Removing command " + c.toString());
            commandRepository.delete(c);
        }

        logger.debug("Remove finish");
        return true;
    }
}
