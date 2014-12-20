package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.service.repository.DishRepository;
import com.menudesigner.sjbs.service.repository.TypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by JIN Benli on 18/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class TypeTest {

    private static final Logger logger = LoggerFactory.getLogger(CommandTest.class);

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private DishRepository dishRepository;

    @Test
    public void addSimpleTypeTest() {
        Type type = new Type();

        type.setIs_firstmenu(true);
        type.setIs_secondmenu(false);
        type.setName("cold");
        type.setDescription("cold");
        type.setIs_for_customize(false);

        logger.info("[TypeTest] addSimpleTypeTest", type);

        assertThat(type, notNullValue());
    }

    @Test
    public void removeSimpleTypeTest() {
        Type type = new Type();

        type.setIs_firstmenu(true);
        type.setIs_secondmenu(false);
        type.setName("cold");
        type.setDescription("cold");
        type.setIs_for_customize(false);

        logger.info("[TypeTest] addSimpleTypeTest", type);

        Type theType = typeRepository.save(type);
        typeRepository.delete(theType);
        Type theRes = typeRepository.findOne(theType.getId());

        assertThat(theType, notNullValue());
        assertThat(theRes, nullValue());
    }

    @Test
    public void addTypeWithDishTest() {
        Type type = new Type();

        type.setIs_firstmenu(true);
        type.setIs_secondmenu(false);
        type.setName("cold");
        type.setDescription("cold");
        type.setIs_for_customize(false);

        Dish newDish = new Dish();
        newDish.setName("coca");
        newDish.setIs_typed(false);
        newDish.setImg_path("abc");
        newDish.setPrice(5);
        newDish.setDescription("abc");
        newDish.setDisabled(false);
        newDish.setStart_time(new Time(10,10,10));
        newDish.setEnd_time(new Time(10,11,10));
        newDish.setStart_date(new Date(2014,10,12));
        newDish.setEnd_date(new Date(2014,11,12));

        newDish.addType(type);
        type.addDish(newDish);

        Dish res1 = dishRepository.save(newDish);
        Type res2 = typeRepository.save(type);

        assertThat(res1, notNullValue());
        assertThat(res2, notNullValue());

        assertThat(res1.getTypes().contains(res2), is(Boolean.TRUE));
        assertThat(res2.getDishes().contains(res1), is(Boolean.TRUE));
    }
}
