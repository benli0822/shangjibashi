package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.Command;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface CommandRepository extends CrudRepository<Command, Long>, MongoRepository<Command, Long> {
  List<Command> findCommandByTitle(String title);
}
