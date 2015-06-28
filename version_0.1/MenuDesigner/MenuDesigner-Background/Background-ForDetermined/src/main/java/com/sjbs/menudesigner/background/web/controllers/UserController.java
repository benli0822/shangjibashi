package com.sjbs.menudesigner.background.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by b.jin on 18/03/2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @RequestMapping(value = "/general", method = RequestMethod.GET)
  public String general() {
    return "views/user/general";
  }

  @RequestMapping(value = "/facebook", method = RequestMethod.GET)
  public String facebook() {
    //TODO social network connection
    return "";
  }

  @RequestMapping(value = "/twitter", method = RequestMethod.GET)
  public String twitter() {
    //TODO twitter connection
    return "";
  }

  //TODO other social network connection

}
