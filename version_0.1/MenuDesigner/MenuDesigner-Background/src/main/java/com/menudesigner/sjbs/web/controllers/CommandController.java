package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.service.CommandService;
import com.menudesigner.sjbs.service.repository.CommandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created by JIN Benli on 03/02/15.
 */
@Controller
@RequestMapping(value = "/command")
public class CommandController
{
    private static final Logger logger = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private CommandService commandService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCommand(Locale locale, Model model)
    {
        model.addAttribute("commands", commandRepository.findAll());
        return "views/command/list";
    }
}
