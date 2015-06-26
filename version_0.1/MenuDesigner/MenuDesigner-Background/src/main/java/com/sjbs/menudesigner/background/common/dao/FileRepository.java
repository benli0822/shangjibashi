package com.sjbs.menudesigner.background.common.dao;

import com.sjbs.menudesigner.background.common.bo.File;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 28/12/14.
 */
public interface FileRepository extends CrudRepository<File, Long> {
  List<File> findFileByName(String name);
}
