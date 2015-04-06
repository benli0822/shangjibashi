package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.File;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 28/12/14.
 */
public interface FileRepository extends CrudRepository<File, Long>
{
    List<File> findFileByName(String name);
}
