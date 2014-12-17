package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.service.repository.CommandRepository;
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
* Created by JIN Benli on 17/12/14.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@SpringApplicationConfiguration(classes = Application.class)
public class CommandTest {

    private static final Logger logger = LoggerFactory.getLogger(CommandTest.class);

    @Autowired
    private CommandRepository commandRepository;

    @Test
    public void addSimpleCommandTest() {
        Command command = new Command();

        command.setTitle("Bob");
        command.setMsg_extra("test");
        command.setOrder_date(new Date(2014, 10 ,12));
        command.setOrder_time(new Time(20, 20, 20));
        command.setTable_no(1);
        command.setClient_no(5);

        logger.info("[CommandTest] addSimpleCommandTest", command);

        Command theCommand = commandRepository.save(command);

        assertThat(theCommand.getId(), notNullValue());

    }

    @Test
    public void removeSimpleCommandTest() {
        Command command = new Command();

        command.setTitle("Bob");
        command.setMsg_extra("test");
        command.setOrder_date(new Date(2014, 10 ,12));
        command.setOrder_time(new Time(20, 20, 20));
        command.setTable_no(1);
        command.setClient_no(5);

        logger.info("[CommandTest] removeSimpleCommandTest", command);

        Command theCommand = commandRepository.save(command);
        commandRepository.delete(theCommand);

        Command theRes = commandRepository.findOne(theCommand.getId());

        assertThat(theCommand, notNullValue());
        assertThat(theRes, nullValue());

    }
}
