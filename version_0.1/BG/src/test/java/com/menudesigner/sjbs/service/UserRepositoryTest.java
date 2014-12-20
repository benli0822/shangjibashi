//package com.menudesigner.sjbs.service;
//
//import com.menudesigner.sjbs.Application;
//import com.menudesigner.sjbs.domain.User;
//import com.menudesigner.sjbs.service.repository.UserRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertThat;
//
///**
//* Created by JIN Benli on 12/10/14.
//*/
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Test
//    public void searchNameNotExist() {
//        List<User> notFound = repository.findUserByUsername("Not Found");
//        assertThat(notFound.size(), is(0));
//    }
//
//    @Test
//    public void searchRoot() {
//        List<User> notFound = repository.findUserByUsername("root");
//        assertThat(notFound.size(), is(1));
//    }
//
//
//}
