package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Option;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.OptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by JIN Benli on 13/01/15.
 */
@Service
@Component("optionService")
@Transactional
public class OptionServiceImpl implements OptionService {
    private static final Logger logger = LoggerFactory.getLogger(OptionServiceImpl.class);

    private final OptionRepository optionRepository;
    private final DishRepository dishRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository, DishRepository dishRepository) {
        this.optionRepository = optionRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public long addOption(Option option) {
        logger.debug("Try adding option: " + option.toString());
        if(optionRepository.findOptionByName(option.getName()).size() == 0) {
            Option theOption = optionRepository.save(option);
            logger.info("Option");
            return theOption.getId();
        } else {
            logger.error("Option " + option.toString() + " existed!");
            return -1L;
        }
    }

    @Override
    public long addOption(String name) {
        logger.debug("Try adding option");

        Option option = new Option();

        option.setName(name);

        return this.addOption(option);
    }

    @Override
    public boolean addOptionToDish(long dish_id, long option_id) {
        logger.debug("Try adding option to dish");
        Dish dish = dishRepository.findOne(dish_id);
        Option option = optionRepository.findOne(option_id);
        assert dish != null;
        assert option != null;

        if(dish.getOptions().contains(option) && option.getDishes().contains(dish)) {
            logger.info("Option " + option.toString()+ " existed in dish " + dish.toString());
            return false;
        } else {
            logger.info("Option " + option.toString() + " added to dish" + dish.toString());
            option.addDish(dish);

            return true;
        }
    }

    @Override
    public boolean removeOption(String name) {
        logger.debug("Removing option name " + name);

        List<Option> options = optionRepository.findOptionByName(name);

        if(options.size() == 0) {
            logger.debug("Option not found!");
            return false;
        }

        for(Option o :options) {
            logger.debug("Removing option " + o.toString());
            optionRepository.delete(o);
        }

        logger.debug("Remove finish");
        return true;
    }
}
