package com.menudesigner.sjbs.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.menudesigner.sjbs.domain.Type;
import com.menudesigner.sjbs.service.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/**
 * Created by JIN Benli on 26/01/15.
 */
@Controller
@RequestMapping("/api")
public class DomainRestController {
    private static final Logger logger = LoggerFactory.getLogger(DomainRestController.class);

    @Autowired
    private TypeRepository typeRepository;

    @JsonIgnore
    @RequestMapping(value = "/getTypes", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Type> getTypes(Locale locale) {
        return (List<Type>) typeRepository.findAll();
    }
}
