package com.menudesigner.sjbs.domain.database.repository;

import com.menudesigner.sjbs.domain.database.object.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 12/10/14.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByUsername(String username);
}
