package com.menudesigner.sjbs.db.database.object;

import javax.persistence.*;

/**
 * Created by JIN Benli on 12/10/14.
 */
@Entity
@Table(name = "jb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String type;

    protected User() {}

    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, username='%s', password='%s', type='%s']",
                id, username, password, type);
    }
}
