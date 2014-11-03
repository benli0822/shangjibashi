package com.menudesigner.sjbs.service;

import com.menudesigner.sjbs.domain.Type;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface TypeRepository {
    List<Type> findTypeByName(String name);
}
