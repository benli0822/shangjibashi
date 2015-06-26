package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.Activity;
import com.sjbs.menudesigner.background.domain.Command;
import com.sjbs.menudesigner.background.domain.CommandActivity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandActivityRepository extends CrudRepository<CommandActivity, Long> {
  List<CommandActivity> findCommandActivityByCommandAndActivity(Command command, Activity activity);
}
