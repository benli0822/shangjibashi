package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.service.repository.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JIN Benli on 15/01/15.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

  private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

  @Autowired
  private DishRepository dishRepository;

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String add(Model model) {
    logger.info("[MenuController: add] Called");

    model.addAttribute("dishes", dishRepository.findAll());

    return "views/menu/add";
  }

  @RequestMapping(method = RequestMethod.GET)
  public String list() {
    return "views/menu/list";
  }

}
