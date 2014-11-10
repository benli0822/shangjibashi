package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Command;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface CommandRepository extends CrudRepository<Command, Long> {
    List<Command> findCommandByTable(Integer table);
}
