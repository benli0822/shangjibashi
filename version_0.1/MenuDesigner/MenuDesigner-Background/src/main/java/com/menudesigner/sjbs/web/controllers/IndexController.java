package com.menudesigner.sjbs.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Back office index page.
 * Created by JIN Benli on 16/09/13.
 */

@Controller
public class IndexController implements BaseController {
  private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

  /**
   * Simply selects the home view to render by returning its name.
   * @param locale Localisation settings
   * @param model Page model
   * @return Thymeleaf path
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);

    return "views/index";
  }

  /**
   *
   * @param request
   * @param response
   * @param servletContext
   * @param templateEngine
   */
  @Override
  public void process(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext,
                      TemplateEngine templateEngine) {

  }
}
