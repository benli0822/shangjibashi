package com.menudesigner.database.JDBCTemplate;

import com.menudesigner.database.dao.UserDao;
import com.menudesigner.database.mapper.UserMapper;
import com.menudesigner.database.object.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by JIN Benli on 12/10/14.
 */
public class UserJDBCTemplate implements UserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

    @Override
    public void create(String username, String password, String type) {
        String sql = "INSERT INTO jb_user (NAME, PASSWD, TYPE) values (?, ?, ?)";

        jdbcTemplateObject.update(sql, username, password, type);
        System.out.println("Created record Username: " + username + " Type: " + type);
        return;
    }

    @Override
    public User getUser(Integer id) {
        String sql = "SELECT * FROM jb_user WHERE ID = ?";

        User user = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    @Override
    public List<User> listUsers() {
        String sql = "SELECT * FROM jb_user";

        List<User> users = jdbcTemplateObject.query(sql, new UserMapper());
        return users;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM jb_user WHERE ID = ?";

        jdbcTemplateObject.update(sql, id);
        System.out.println("Deleted record with ID = " + id);
        return;
    }

    @Override
    public void updatePassword(Integer id, String password) {
        String sql = "UPDATE jb_user SET PASSWD = ? WHERE ID = ?";

        jdbcTemplateObject.update(sql, id, password);
        System.out.println("Update record with ID = " + id + " PASSWORD = " + password);
    }

    @Override
    public void updateType(Integer id, String type) {
        String sql = "UPDATE jb_user SET TYPE = ? WHERE ID = ?";

        jdbcTemplateObject.update(sql, id, type);
        System.out.println("Update record with ID = " + id + " TYPE = " + type);
    }

    @Override
    public void updatePasswordAndType(Integer id, String password, String type) {
        String sql = "UPDATE jb_user SET (PASSWD, TYPE) VALUES (?, ?) WHERE ID = ?";

        jdbcTemplateObject.update(sql, id, password, type);
        System.out.println("Update record with ID = " + id + " PASSWORD = " + password + " TYPE = " + type);

    }
}
