//package com.menudesigner.sjbs.db.database;
//
//import com.menudesigner.sjbs.domain.database.JDBCTemplate.UserJDBCTemplate;
//import com.menudesigner.sjbs.domain.database.object.User;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
///**
// * Created by JIN Benli on 12/10/14.
// */
//public class UserTest {
//    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("classpath:beans.xml");
//
//        UserJDBCTemplate userJDBCTemplate =
//                (UserJDBCTemplate) context.getBean("studentJDBCTemplate");
//
//
//        System.out.println("------Listing Multiple Records--------");
//        List<User> users = userJDBCTemplate.listUsers();
//        for (User record : users) {
//            System.out.print("ID : " + record.getId());
//            System.out.print(", Name : " + record.getUsername());
//            System.out.println(", Password : " + record.getPassword());
//            System.out.println(", Type : " + record.getType());
//        }
//    }
//}
