package com.menudesigner.database.dao;

import com.menudesigner.database.object.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by JIN Benli on 12/10/14.
 */
public interface UserDao {
    /**
     * This is the method to be used to initialize database resources ie: connection.
     * @param ds
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create a new user record in the User table.
     * @param username
     * @param password
     * @param type
     */
    public void create(String username, String password, String type);

    /**
     * This is the method to be used to list down a record from User table corresponding to
     * a passed user id
     * @param id
     * @return
     */
    public User getUser(Integer id);

    /**
     * This is the method to be used to list down all records from User table
     * @return
     */
    public List<User> listUsers();

    /**
     * This is the method to be used to delete a record form User table corresponding to
     * a passed user id
     * @param id
     */
    public void delete(Integer id);

    /**
     * This is the method to be used to update the password with the given user id
     * @param id
     * @param password
     */
    public void updatePassword(Integer id, String password);

    /**
     * This is the method to be used to change the type with the given user id
     * @param id
     * @param type
     */
    public void updateType(Integer id, String type);

    /**
     * This is the method to be used to change the password and the type with the given id
     * @param id
     * @param password
     * @param type
     */
    public void updatePasswordAndType(Integer id, String password, String type);

}
