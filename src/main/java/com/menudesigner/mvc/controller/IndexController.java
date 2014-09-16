package com.menudesigner.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by JIN Benli on 16/09/14.
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView index = new ModelAndView("index");
        return index;
    }
}
