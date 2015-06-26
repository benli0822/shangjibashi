package com.sjbs.menudesigner.background.service;

import com.sjbs.menudesigner.background.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by JIN Benli on 04/04/15.
 */
@Service
public interface UserService {

  long createUser(User user);

  long createUser(String username, String password, String type);

}
