package com.menudesigner.sjbs;

import com.menudesigner.sjbs.domain.User;
import com.menudesigner.sjbs.service.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JIN Benli on 27/10/14.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        UserRepository repository = context.getBean(UserRepository.class);

        repository.save(new User("user1","user1","admin"));
        repository.save(new User("user2","user2","admin"));
        repository.save(new User("user3","user3","admin"));
        repository.save(new User("user4","user4","admin"));

        Iterable<User> users = repository.findAll();
        System.out.println("Users found with findAll()");
        System.out.println("-------------------------------");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();

        context.close();

    }
}
