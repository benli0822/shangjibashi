package com.sjbs.menudesigner.background.common.dao;

import com.sjbs.menudesigner.background.common.bo.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface MenuRepository extends CrudRepository<Menu, Long> {
  List<Menu> findMenuByName(String name);
}
