package com.sjbs.menudesigner.background;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JIN Benli on 13/10/14.
 */
@Configuration
@EnableAutoConfiguration
public class ApplicationTest {

//    public static void main(String[] args) {
//
//        ConfigurableApplicationContext context = SpringApplication.run(ApplicationTest.class);
//        UserRepository repository = context.getBean(UserRepository.class);
//
//        // save a couple of user
//        repository.save(new User("tom", "123", "normal"));
//        repository.save(new User("alice", "123", "normal"));
//        repository.save(new User("mike", "123", "normal"));
//
//        // fetch all users
//        Iterable<User> users = repository.findAll();
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (User user : users) {
//            System.out.println(user);
//        }
//        System.out.println();
//
//        // fetch an individual user by ID
//        User user = repository.findOne(1L);
//        System.out.println("Customer found with findOne(1L):");
//        System.out.println("--------------------------------");
//        System.out.println(user);
//        System.out.println();
//
//        // fetch customers by last name
//        List<User> admin = repository.findUserByUsername("admin");
//        System.out.println("User found with findUserByUsername('admin'):");
//        System.out.println("--------------------------------------------");
//        for (User ad : admin) {
//            System.out.println(ad);
//        }
//
//        context.close();
//    }
}
