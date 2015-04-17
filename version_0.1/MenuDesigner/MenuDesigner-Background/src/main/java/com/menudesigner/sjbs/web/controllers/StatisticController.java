package com.menudesigner.sjbs.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JIN Benli on 16/01/15.
 */
@Controller
@RequestMapping("/statistic")
public class StatisticController {
    private static final Logger logger = LoggerFactory.getLogger(StatisticController.class);

    @RequestMapping(value = "/command", method = RequestMethod.GET)
    public String command() {
        return "views/statistic/command";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation() {
        return "views/statistic/reservation";
    }

}
