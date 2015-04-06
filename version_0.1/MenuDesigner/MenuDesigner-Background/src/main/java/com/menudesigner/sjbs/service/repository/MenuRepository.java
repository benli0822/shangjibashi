package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 10/11/14.
 */
public interface MenuRepository extends CrudRepository<Menu, Long>
{
    List<Menu> findMenuByName(String name);
}
