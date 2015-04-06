package com.menudesigner.sjbs.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JIN Benli on 15/01/15.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController
{

    private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add()
    {
        return "views/activity/add";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list()
    {
        return "views/activity/list";
    }
}
