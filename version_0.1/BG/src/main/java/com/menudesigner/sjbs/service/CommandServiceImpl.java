package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Command;
import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.service.repository.ActivityRepository;
import com.menudesigner.sjbs.service.repository.CommandRepository;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Component("commandService")
@Transactional
public class CommandServiceImpl implements CommandService {
    private static final Logger logger = LoggerFactory.getLogger(CommandServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final CommandRepository commandRepository;
    private final DishRepository dishRepository;
    private final ActivityRepository activityRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public CommandServiceImpl(JdbcTemplate jdbcTemplate, CommandRepository commandRepository, DishRepository dishRepository, ActivityRepository activityRepository, MenuRepository menuRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.commandRepository = commandRepository;
        this.dishRepository = dishRepository;
        this.activityRepository = activityRepository;
        this.menuRepository = menuRepository;
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
    public long addCommand(String title, String msg_extra, int table_no, int client_no) {
        logger.debug("Try adding command");

        Command command = new Command();
        command.setTitle(title);
        command.setMsg_extra(msg_extra);
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

        logger.debug("Dish " + theDish.toString() + " Command " + theCommand.toString() + " with quantity: " + quantity);
        //TODO how to handle quantity problem?

        if(!theDish.getCommands().contains(theCommand) && !theCommand.getDishes().contains(theDish)) {
//            theDish.addCommand(theCommand);
//            theCommand.addDish(theDish);
//            Dish res1 = dishRepository.save(theDish);
//            Command res2 = commandRepository.save(theCommand);

//            String SQL = "UPDATE jb_menu_design.md_command_dish SET quantity = ? WHERE command_id = ? AND dish_id = ?";
//            jdbcTemplate.update(SQL, quantity, theCommand.getId(), theDish.getId());
            return true;
        } else {
            logger.error("neither dish " + theDish.toString() + "nor command " + theCommand.toString() + "has already associated with each other!");
            return false;
        }
    }

    @Override
    public boolean addActivityToCommand(long activity_id, long command_id, int quantity) {
        return false;
    }

    @Override
    public boolean addMenuToCommand(long menu_id, long command_id, int quantity) {
        return false;
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