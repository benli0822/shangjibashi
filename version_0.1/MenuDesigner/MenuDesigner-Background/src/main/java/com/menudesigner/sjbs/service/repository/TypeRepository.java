package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 18/12/14.
 */
public interface TypeRepository extends CrudRepository<Type, Long>
{
    List<Type> findTypeByName(String name);

    List<Type> findTypeByDescription(String description);
}
