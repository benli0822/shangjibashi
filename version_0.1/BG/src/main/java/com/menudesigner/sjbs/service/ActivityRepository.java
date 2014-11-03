package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Activity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface ActivityRepository extends CrudRepository<Activity, Long> {
    List<Activity> findActivityByName(String name);
}
