package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by JIN Benli on 12/10/14.
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByUsername(@Param("name")String username);
}
