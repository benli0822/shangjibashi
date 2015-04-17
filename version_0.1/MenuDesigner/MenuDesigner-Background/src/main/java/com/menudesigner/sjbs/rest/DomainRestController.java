package com.menudesigner.sjbs.rest;

import com.menudesigner.sjbs.domain.*;
import com.menudesigner.sjbs.rest.dto.CommandDTO;
import com.menudesigner.sjbs.service.CommandService;
import com.menudesigner.sjbs.service.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * iMenu Domain rest service
 * <p/>
 * Created by JIN Benli on 26/01/15.
 */
@Controller
@RequestMapping("/api")
public class DomainRestController {
    private static final Logger logger = LoggerFactory.getLogger(DomainRestController.class);

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CommandService commandService;

    @RequestMapping(value = "/getTypes", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Type> getTypes(Locale locale) {
        logger.info("[DomainRestController]: getTypes called");
        return (List<Type>) typeRepository.findAll();
    }

    @RequestMapping(value = "/getMenus", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Menu> getMenus(Locale locale) {
        logger.info("[DomainRestController]: getMenus called");
        return (List<Menu>) menuRepository.findAll();
    }

    @RequestMapping(value = "/getActivities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Activity> getActivities(Locale locale) {
        logger.info("[DomainRestController]: getActivities called");
        return (List<Activity>) activityRepository.findAll();
    }

    @RequestMapping(value = "/getCommands", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Command> getCommands(Locale locale) {
        logger.info("[DomainRestController]: getCommands called");
        return (List<Command>) commandRepository.findAll();
    }

    @RequestMapping(value = "/getDishes", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Dish> getDishes(Locale locale) {
        logger.info("[DomainRestController]: getDishes called");
        return (List<Dish>) dishRepository.findAll();
    }

    @RequestMapping(value = "/getFiles", method = RequestMethod.GET)
    public
    @ResponseBody
    List<File> getFiles(Locale locale) {
        logger.info("[DomainRestController]: getFiles called");
        return (List<File>) fileRepository.findAll();
    }

    @RequestMapping(value = "/getOptions", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Option> getOptions(Locale locale) {
        logger.info("[DomainRestController]: getOptions called");
        return (List<Option>) optionRepository.findAll();
    }

    @RequestMapping(value = "/postCommands", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean postCommands(@RequestBody CommandDTO commandDTO) {

        logger.info(commandDTO.toString());

        // use command service to create a simple no content command
        final long command_id = commandService.addCommand(
                commandDTO.getTitle(),
                commandDTO.getMsg_extra(),
                commandDTO.getPrice(),
                commandDTO.getTable_no(),
                commandDTO.getClient_no()
        );

        // add dishes to command
        Map<String, String> d = commandDTO.getDish_dictionary();

        for (Map.Entry<String, String> entry : d.entrySet()) {
            // loop to get the dynamic key dish id
            String dish_id = entry.getKey();
            logger.info("Dish_id " + dish_id);

            // get the value of the dynamic key quantity
            String quantity = entry.getValue();
            logger.info("Dish Quantity " + quantity);

            assert !Objects.equals(quantity, "");
            commandService.addDishToCommand(Long.parseLong(dish_id), command_id, Integer.parseInt(quantity));
        }

        // add menus to command
        Map<String, String> m = commandDTO.getMenu_dictionary();

        for (Map.Entry<String, String> entry : m.entrySet()) {
            // loop to get the dymaic key menu id
            String menu_id = entry.getKey();
            logger.info("Menu_id " + menu_id);

            String quantity = entry.getValue();
            logger.info("Menu Quantity " + quantity);

            assert !Objects.equals(quantity, "");
            commandService.addMenuToCommand(Long.parseLong(menu_id), command_id, Integer.parseInt(quantity));
        }

        // add activities to command
        Map<String, String> a = commandDTO.getActivity_dictionary();
        for (Map.Entry<String, String> entry : a.entrySet()) {
            // loop to get the dymaic key menu id
            String activity_id = entry.getKey();
            logger.info("Activity_id " + activity_id);

            // get the value of the dynamic key quantity
            String quantity = entry.getValue();
            logger.info("Activity Quantity " + quantity);

            assert !Objects.equals(quantity, "");
            commandService.addActivityToCommand(Long.parseLong(activity_id), command_id, Integer.parseInt(quantity));
        }

        return true;
    }
}
