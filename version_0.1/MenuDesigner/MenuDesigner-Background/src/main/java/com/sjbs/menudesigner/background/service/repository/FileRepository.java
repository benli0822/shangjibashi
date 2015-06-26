package com.sjbs.menudesigner.background.service.repository;

import com.sjbs.menudesigner.background.domain.File;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 28/12/14.
 */
public interface FileRepository extends CrudRepository<File, Long> {
  List<File> findFileByName(String name);
}
