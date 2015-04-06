package com.menudesigner.sjbs.web.controllers;

import com.menudesigner.sjbs.domain.Type;
import com.menudesigner.sjbs.service.TypeService;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.OptionRepository;
import com.menudesigner.sjbs.service.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by JIN Benli on 03/02/15.
 */
@Controller
@RequestMapping(value = "/type")
public class TypeController
{
    private static final Logger logger = LoggerFactory.getLogger(TypeController.class);

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private TypeService typeService;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OptionRepository optionRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean addType(Locale locale,
                    @RequestParam(value = "oper", required = true) String operation,
                    @RequestParam(value = "name", required = true) String name,
                    @RequestParam(value = "parent", required = true) String parent,
                    @RequestParam(value = "root", required = true) String isRoot)
    {
        assert !Objects.equals(operation, "") && operation != null;

        switch (operation)
        {
            case "add":
            {
                logger.info("Trying add type: " + name);
                // TODO type name not null in entity
                // TODO change description to name
                // TODO is_for_customize?
                if (Objects.equals(isRoot, "Yes"))
                {
                    long res = typeService.createType(true, false, -1L, name, name, false);
                    return res != -1L && res > 0L;
                } else
                {
                    List<Type> theParent = typeRepository.findTypeByDescription(parent);
                    logger.info(theParent.toString());
                    assert theParent.size() != 0;
                    long res = typeService.createType(false, true, theParent.get(0).getId(), name, name, false);
                    return res != -1L && res > 0L;
                }
            }
            default:
        }

        return false;
    }

}
