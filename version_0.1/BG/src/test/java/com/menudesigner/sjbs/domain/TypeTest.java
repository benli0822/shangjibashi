package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
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
}
