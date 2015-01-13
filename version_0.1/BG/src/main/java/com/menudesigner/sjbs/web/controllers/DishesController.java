package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Option;
import com.menudesigner.sjbs.domain.Type;
import com.menudesigner.sjbs.service.DishService;
import com.menudesigner.sjbs.service.TypeService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by JIN Benli on 24/09/14.
 */
@Controller
public class DishesController {
    private static final Logger logger = LoggerFactory.getLogger(DishesController.class);

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishService dishService;

    @Autowired
    private TypeService typeService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public String dish(Locale locale, Model model) {
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

        // put all existing types into page
        model.addAttribute("types", typeRepository.findAll());

        // put all existing options into page
        model.addAttribute("options", optionRepository.findAll());

        logger.info(model.toString());

        return "views/addDish";
    }


    /**
     * ATTENTION: bindingResult must go after @Valid XXX XXX, otherwise can not work
     *
     * @param dish
     * @param bindingResult
     * @param locale
     * @param model
     * @return
     */
    @RequestMapping(value = "/addDish", method = RequestMethod.POST)
    public String checkDishInfo(@Valid Dish dish, BindingResult bindingResult, Locale locale, ModelMap model, HttpServletRequest request) {
        logger.info("[DishesController: addNewDish], posting a new Dish");
        if (bindingResult.hasErrors()) {
            logger.error("[DishesController: postNewDish]", bindingResult.getAllErrors());
            return "views/addDish";
        }
//        logger.info(bindingResult + "");
//        logger.info(dish.toString());

        List<Type> type1List = null;
        List<Type> type2List = null;
        List<Option> optionList = null;
        Type type1 = null;
        Type type2 = null;
        Option option = null;
        // get the keyword from http request
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if(entry.getKey().equals("typeSelector")) {
                String type1_key = entry.getValue()[0];
                type1List = typeRepository.findTypeByName(type1_key);
                type1 = type1List.get(0);
                logger.info(type1.toString());

            }
            if(entry.getKey().equals("typeSelector2")) {
                String type2_key = entry.getValue()[0];
                type2List = typeRepository.findTypeByName(type2_key);
                type2 = type2List.get(0);
                logger.info(type2.toString());
            }
            if(entry.getKey().equals("optionSelector")) {
                String option_key = entry.getValue()[0];
                optionList = optionRepository.findOptionByName(option_key);
                option = optionList.get(0);
                logger.info(option.toString());
            }
//            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }

        long id = dishService.addDish(dish);
        assert id > 0;

        logger.info(dishRepository.findAll().toString());

        if(type1 != null) {
            boolean res = typeService.addTypeToDish(id, type1.getId());
            assert res;
            dishRepository.findOne(id).setIs_typed(true);
        }
        if(type2 != null) {
            boolean res = typeService.addTypeToDish(id, type2.getId());
            assert res;
            dishRepository.findOne(id).setIs_typed(true);
        }

        if(option != null) {
            boolean res =
        }

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
