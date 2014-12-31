package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.OptionRepository;
import com.menudesigner.sjbs.service.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by JIN Benli on 24/09/14.
 */
@Controller
public class DishesController  {
    private static final Logger logger = LoggerFactory.getLogger(DishesController.class);

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private DishRepository dishRepository;

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
    public String addNewDish(Dish dish, Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "views/addDish";
    }


    /**
     * ATTENTION: bindingResult must go after @Valid XXX XXX, otherwise can not work
     * @param dish
     * @param bindingResult
     * @param locale
     * @param model
     * @return
     */
    @RequestMapping(value = "/addDish", method = RequestMethod.POST)
    public String checkDishInfo(@Valid Dish dish, BindingResult bindingResult, Locale locale, ModelMap model) {
        logger.info("[DishesController: addNewDish], posting a new Dish");
        if (bindingResult.hasErrors()) {
            logger.error("[DishesController: postNewDish]", bindingResult.getAllErrors());
            return "views/addDish";
        }
        logger.info(bindingResult + "");
        logger.info(dish.toString());
        return "views/addDish";
    }

    // TODO error handling, class should implements ErrorController
//    private static final String PATH = "/error";
//
//    @RequestMapping(value = PATH)
//    public void error(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.sendRedirect("/404");
//    }
//
//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }
}
