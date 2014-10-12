package com.menudesigner.database.object;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by JIN Benli on 12/10/14.
 */
@Entity
@Table(name = "jb_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
