package com.menudesigner.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by JIN Benli on 17/09/14.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView login = new ModelAndView("login");
        return login;
    }
}
