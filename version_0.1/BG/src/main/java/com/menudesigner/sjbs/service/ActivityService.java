package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Activity;

/**
 * Created by JIN Benli on 17/12/14.
 */
public interface ActivityService {
    boolean addActivity(Activity activity);
    boolean removeActivity(Activity activity);
}
