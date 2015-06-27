package com.sjbs.menudesigner.background.common.repository;

import com.sjbs.menudesigner.background.common.bo.Activity;
import com.sjbs.menudesigner.background.common.bo.Command;
import com.sjbs.menudesigner.background.common.bo.CommandActivity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandActivityRepository extends CrudRepository<CommandActivity, Long> {
  List<CommandActivity> findCommandActivityByCommandAndActivity(Command command, Activity activity);
}
