package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.Command;
import com.sjbs.menudesigner.background.domain.CommandMenu;
import com.sjbs.menudesigner.background.domain.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 22/12/14.
 */
public interface CommandMenuRepository extends CrudRepository<CommandMenu, Long> {
  List<CommandMenu> findCommandMenuByCommandAndMenu(Command command, Menu menu);
}
