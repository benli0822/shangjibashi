package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.File;
import com.menudesigner.sjbs.domain.Option;
import com.menudesigner.sjbs.domain.Type;
import com.menudesigner.sjbs.service.DishService;
import com.menudesigner.sjbs.service.FileService;
import com.menudesigner.sjbs.service.OptionService;
import com.menudesigner.sjbs.service.TypeService;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.FileRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by JIN Benli on 24/09/14.
 */
@Controller
@RequestMapping(value = "/dish")
public class DishController {
    private static final Logger logger = LoggerFactory.getLogger(DishController.class);

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

    @Autowired
    private OptionService optionService;

    @Autowired
    private FileService fileService;

    @Autowired
    private FileRepository fileRepository;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String dish(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        model.addAttribute("dishes", dishRepository.findAll());

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "views/dish/list";
    }

    @RequestMapping(value = "/property", method = RequestMethod.GET)
    public String property(Locale locale, Model model) {
        logger.info("[DishController: property] Called");

//        model.addAttribute("types", typeRepository.findAll());
        return "views/dish/property";
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
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

        return "views/dish/add";
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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String checkDishInfo(@Valid Dish dish, BindingResult bindingResult, Locale locale, ModelMap model, HttpServletRequest request) {
        logger.info("[DishesController: addNewDish], posting a new Dish");
        if (bindingResult.hasErrors()) {
            logger.error("[DishesController: postNewDish]", bindingResult.getAllErrors());
            return "views/dish/add";
        }
//        logger.info(bindingResult + "");
//        logger.info(dish.toString());

        List<Type> type1List;
        List<Type> type2List = new ArrayList<>();
        List<Option> optionList = new ArrayList<>();
        List<File> imageList = new ArrayList<>();
        Type type1 = null;
        // get the keyword from http request
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if (entry.getKey().equals("typeSelector")) {
                String type1_key = entry.getValue()[0];
                type1List = typeRepository.findTypeByName(type1_key);
                type1 = type1List.get(0);
                logger.info(type1.toString());

            }
            if (entry.getKey().equals("typeSelector2")) {
                String[] type2_key = entry.getValue();
                for (String s : type2_key) {
                    logger.info("Found key " + s);
                    List<Type> tempList = typeRepository.findTypeByName(s);
                    for (Type t : tempList) {
                        if (!type2List.contains(t)) {
                            type2List.add(t);
                        }
                    }
                }
            }
            if (entry.getKey().equals("optionSelector")) {
                String option_key = entry.getValue()[0];
                List<Option> tempList = optionRepository.findOptionByName(option_key);

                for (Option o : tempList) {
                    if (!optionList.contains(o)) {
                        optionList.add(o);
                    }
                }
            }
            if (entry.getKey().equals("image")) {
                String[] option_key = entry.getValue();

                for (String s : option_key) {
                    logger.info("Found key " + s);
                    File file = fileRepository.findOne(Long.parseLong(s));
                    if (!imageList.contains(file)) {
                        imageList.add(file);
                    }
                }
            }
//            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }

        long id = dishService.addDish(dish);
        assert id > 0;

        logger.info(dishRepository.findAll().toString());

        if (type1 != null) {
            boolean res = typeService.addTypeToDish(id, type1.getId());
            assert res;
            dishRepository.findOne(id).setIs_typed(true);
        }

        logger.info(type2List.toString());
        assert type2List.size() != 0;
        if (type2List.size() != 0) {
            for (Type t : type2List) {
                boolean res = typeService.addTypeToDish(id, t.getId());
                assert res;
                dishRepository.findOne(id).setIs_typed(true);
            }
        }

        if (optionList.size() != 0) {
            for (Option o : optionList) {
                boolean res = optionService.addOptionToDish(id, o.getId());
                assert res;
            }
        }

        if (imageList.size() != 0) {
            for (File f : imageList) {
                boolean res = fileService.addFileToDish(id, f.getId());
                assert res;
            }
        }

        model.addAttribute("dish", dishRepository.findOne(id));

        return "views/dish/invoice";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("dish", dishRepository.findOne(1L));
        return "views/dish/invoice";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public @ResponseBody boolean removeDish(@RequestParam(value = "id", required = true)int id) {
        Dish dish = dishRepository.findOne((long)id);
        assert dish != null;
        return dishService.removeDish(dish.getName());
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
