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
@RequestMapping("/property")
public class SystemController
{

    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping(value = "/general", method = RequestMethod.GET)
    public String general()
    {
        return "views/property/general";
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String config()
    {
        return "views/property/config";
    }

}
