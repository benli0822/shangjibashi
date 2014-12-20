package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.domain.Dish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by JIN Benli on 24/09/14.
 */
@Controller
public class DishesController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public String index(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "views/dish";
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/addDish", method = RequestMethod.GET)
    public String addNewDish(final Dish dish, Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "views/addDish";
    }


    @RequestMapping(value = "/addDish", method = RequestMethod.POST)
    public String addNewDish(final Dish dish, Locale locale, final BindingResult bindingResult, final ModelMap model) {
        logger.info("[DishesController: addNewDish], posting a new Dish");
        if (bindingResult.hasErrors()) {
            logger.error("[DishesController: postNewDish]", bindingResult.getAllErrors());
            return "view/addDish";
        }
        return null;
    }
}
