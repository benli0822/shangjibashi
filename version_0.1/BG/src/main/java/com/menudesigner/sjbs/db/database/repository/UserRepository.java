package com.menudesigner.sjbs.db.database.repository;

import com.menudesigner.sjbs.db.database.object.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 12/10/14.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByName(String username);
}
