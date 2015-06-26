package com.sjbs.menudesigner.background.web.controllers;

import com.sjbs.menudesigner.background.domain.Dish;
import com.sjbs.menudesigner.background.domain.File;
import com.sjbs.menudesigner.background.domain.Option;
import com.sjbs.menudesigner.background.domain.Type;
import com.sjbs.menudesigner.background.service.DishService;
import com.sjbs.menudesigner.background.service.FileService;
import com.sjbs.menudesigner.background.service.OptionService;
import com.sjbs.menudesigner.background.service.TypeService;
import com.sjbs.menudesigner.background.service.repository.DishRepository;
import com.sjbs.menudesigner.background.service.repository.FileRepository;
import com.sjbs.menudesigner.background.service.repository.OptionRepository;
import com.sjbs.menudesigner.background.service.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
  private MessageSource messageSource;

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

    model.addAttribute("options", optionRepository.findAll());

    model.addAttribute("types", typeRepository.findAll());

    return "redirect:/dish/page/1";
  }

  @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
  public String dish(@PathVariable Integer pageNumber, Model model, Locale locale) {
    logger.info("Welcome home! The client locale is {}.", locale);

    PageRequest pageRequest =
        new PageRequest(pageNumber - 1, 12);

    Page<Dish> currentResults = dishRepository.findAll(pageRequest);

    logger.info(currentResults.toString());
    model.addAttribute(currentResults);


    // Pagination variables
    int current = currentResults.getNumber() + 1;
    int begin = Math.max(1, current - 5);
    // how many pages to display in the pagination bar
    int end = Math.min(begin + 10, currentResults.getTotalPages());

    model.addAttribute("beginIndex", begin);
    model.addAttribute("endIndex", end);
    model.addAttribute("currentIndex", current);

    model.addAttribute("types", typeRepository.findAll());

    model.addAttribute("options", optionRepository.findAll());

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    model.addAttribute("currentResults", currentResults);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);

    return "views/dish/list";
  }

  @RequestMapping(value = "/type", method = RequestMethod.GET)
  public String type(Locale locale, Model model, @RequestParam(value = "type") String typeDescription) {
    logger.info("Welcome home! The client locale is {}.", locale);

    model.addAttribute("options", optionRepository.findAll());

    model.addAttribute("types", typeRepository.findAll());

    return "redirect:/dish/type/1?type=" + typeDescription;
  }

  @RequestMapping(value = "/type/{pageNumber}", method = RequestMethod.GET)
  public String dish(@PathVariable Integer pageNumber, @RequestParam(value = "type") String description, Model
      model, Locale locale) {
    logger.info("Welcome home! The client locale is {}.", locale);

    PageRequest pageRequest =
        new PageRequest(pageNumber - 1, 12);

    Page<Dish> currentResults = dishRepository.findDishByTypesDescription(description, pageRequest);

    model.addAttribute(currentResults);

    // Pagination variables
    int current = currentResults.getNumber() + 1;
    int begin = Math.max(1, current - 5);
    // how many pages to display in the pagination bar
    int end = Math.min(begin + 10, currentResults.getTotalPages());

    model.addAttribute("beginIndex", begin);
    model.addAttribute("endIndex", end);
    model.addAttribute("currentIndex", current);

    model.addAttribute("types", typeRepository.findAll());

    model.addAttribute("options", optionRepository.findAll());

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    model.addAttribute("currentResults", currentResults);

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

    // page title
    model.addAttribute("title", this.messageSource.getMessage("add.title", new Object[]{}, null));

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
  public String checkDishInfo(@Valid Dish dish, BindingResult bindingResult, Locale locale, ModelMap model,
                              HttpServletRequest request) {
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

    model.addAttribute("title", this.messageSource.getMessage("add.title", new Object[]{}, null));
    model.addAttribute("dish", dishRepository.findOne(id));

    return "views/dish/invoice";
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test(Model model) {
    model.addAttribute("dish", dishRepository.findOne(1L));
    model.addAttribute("title", this.messageSource.getMessage("add.title", new Object[]{}, null));
    return "views/dish/invoice";
  }

  @RequestMapping(value = "/remove", method = RequestMethod.POST)
  public
  @ResponseBody
  boolean removeDish(@RequestParam(value = "id", required = true) int id) {
    Dish dish = dishRepository.findOne((long) id);
    assert dish != null;
    return dishService.removeDish(dish.getName());
  }

  @RequestMapping(value = "/edit/{dishId}", method = RequestMethod.GET)
  public String editDish(@PathVariable Integer dishId, Model model, Locale locale) {
    logger.info("Welcome home! The client locale is {}.", locale);

    model.addAttribute("dish", dishRepository.findOne((long) dishId));

    model.addAttribute("options", optionRepository.findAll());

    model.addAttribute("title", this.messageSource.getMessage("edit.title", new Object[]{}, null));

    model.addAttribute("types", typeRepository.findAll());
    return "views/dish/edit";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public
  @ResponseBody
  boolean editDish() {
    return false;
  }

  @RequestMapping(value = "/detail/{dishId}", method = RequestMethod.GET)
  public String detailDish(@PathVariable Integer dishId, Model model, Locale locale) {
    logger.info("Welcome home! The client locale is {}.", locale);

    model.addAttribute("dish", dishRepository.findOne((long) dishId));

    model.addAttribute("options", optionRepository.findAll());

    model.addAttribute("types", typeRepository.findAll());

    model.addAttribute("title", this.messageSource.getMessage("detail.title", new Object[]{}, null));

    model.addAttribute("show_alert", false);

    return "views/dish/invoice";
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
