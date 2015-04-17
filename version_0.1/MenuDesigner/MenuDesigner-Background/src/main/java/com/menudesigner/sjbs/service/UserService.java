package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by JIN Benli on 04/04/15.
 */
@Service
public interface UserService {

    long createUser(User user);

    long createUser(String username, String password, String type);

}
