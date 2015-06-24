package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Command;
import com.menudesigner.sjbs.domain.CommandMenu;
import com.menudesigner.sjbs.domain.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandMenuRepository extends CrudRepository<CommandMenu, Long> {
  List<CommandMenu> findCommandMenuByCommandAndMenu(Command command, Menu menu);
}
