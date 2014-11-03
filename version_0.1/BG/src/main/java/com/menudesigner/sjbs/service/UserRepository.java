package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 12/10/14.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByUsername(String username);
}
