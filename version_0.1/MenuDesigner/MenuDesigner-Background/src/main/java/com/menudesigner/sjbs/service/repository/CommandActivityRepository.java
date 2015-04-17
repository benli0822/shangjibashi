package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Activity;
import com.menudesigner.sjbs.domain.Command;
import com.menudesigner.sjbs.domain.CommandActivity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandActivityRepository extends CrudRepository<CommandActivity, Long> {
    List<CommandActivity> findCommandActivityByCommandAndActivity(Command command, Activity activity);
}
