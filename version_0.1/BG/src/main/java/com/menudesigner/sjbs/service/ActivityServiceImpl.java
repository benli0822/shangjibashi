package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Activity;
import com.menudesigner.sjbs.service.repository.ActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by JIN Benli on 17/12/14.
 */
@Component("activityService")
@Transactional
public class ActivityServiceImpl implements ActivityService {
    private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public boolean addActivity(Activity activity) {
        logger.debug("Try adding activity: " + activity.toString());
        if(activityRepository.findActivityByName(activity.getName()).size() == 0) {
            activityRepository.save(activity);
        }
        return false;
    }

    @Override
    public boolean removeActivity(Activity activity) {
        return false;
    }
}
