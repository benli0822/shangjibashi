package com.menudesigner.sjbs.rest;

import com.menudesigner.sjbs.domain.*;
import com.menudesigner.sjbs.service.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/**
 * iMenu Domain rest service
 *
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
}
