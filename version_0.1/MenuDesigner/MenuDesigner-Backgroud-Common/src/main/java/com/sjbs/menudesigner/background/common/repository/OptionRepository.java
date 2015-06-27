package com.sjbs.menudesigner.background.common.repository;

import com.sjbs.menudesigner.background.common.bo.Option;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 20/12/14.
 */
public interface OptionRepository extends CrudRepository<Option, Long> {
  List<Option> findOptionByName(String name);

}
