//package com.menudesigner.sjbs.db.database.mapper;
//
//import com.menudesigner.sjbs.db.database.object.User;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * Created by JIN Benli on 12/10/14.
// */
//public class UserMapper implements RowMapper<User> {
//    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//        User user = new User();
//        user.setId(rs.getInt("ID"));
//        user.setUsername(rs.getString("NAME"));
//        user.setPassword(rs.getString("PASSWD"));
//        user.setType(rs.getString("TYPE"));
//        return user;
//    }
//}
