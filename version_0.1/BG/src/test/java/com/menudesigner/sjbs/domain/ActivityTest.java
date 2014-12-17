package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.Application;
import com.menudesigner.sjbs.service.repository.ActivityRepository;
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
public class ActivityTest {

    private static final Logger logger = LoggerFactory.getLogger(DishTest.class);


    @Autowired
    private ActivityRepository activityRepository;

    @Test
    public void addSimpleActivityTest() {

        Activity activity = new Activity();

        activity.setName("test");
        activity.setDescription("test");
        activity.setStart_date(new Date(2014, 1, 2));
        activity.setEnd_date(new Date(2014, 1, 10));
        activity.setStart_time(new Time(19, 20, 55));
        activity.setEnd_time(new Time(19, 21, 55));

        logger.info("[ActivityTest] addSimpleActivityTest", activity);

        Activity theActivity = activityRepository.save(activity);

        assertThat(theActivity.getId(), notNullValue());
    }

    @Test
    public void removeSimpleActivityTest() {
        Activity activity = new Activity();

        activity.setName("test");
        activity.setDescription("test");
        activity.setStart_date(new Date(2014, 1, 2));
        activity.setEnd_date(new Date(2014, 1, 10));
        activity.setStart_time(new Time(19, 20, 55));
        activity.setEnd_time(new Time(19, 21, 55));

        logger.info("[ActivityTest] removeSimpleActivityTest", activity);

        Activity theActivity = activityRepository.save(activity);
        activityRepository.delete(theActivity);
        Activity theRes = activityRepository.findOne(theActivity.getId());

        assertThat(theActivity, notNullValue());
        assertThat(theRes, nullValue());
    }
}
