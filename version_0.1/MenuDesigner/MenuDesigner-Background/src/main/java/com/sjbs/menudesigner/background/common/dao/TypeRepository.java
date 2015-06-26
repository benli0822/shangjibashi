package com.sjbs.menudesigner.background.common.dao;

import com.sjbs.menudesigner.background.common.bo.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 18/12/14.
 */
public interface TypeRepository extends CrudRepository<Type, Long> {
  List<Type> findTypeByName(String name);

  List<Type> findTypeByDescription(String description);
}
