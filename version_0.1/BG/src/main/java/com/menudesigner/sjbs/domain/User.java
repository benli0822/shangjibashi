package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JIN Benli on 12/10/14.
 */
@Entity
@Table(name = "jb_user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "NAME")
    private String username;
    @Column(name = "PASSWD")
    private String password;
    @Column(name = "TYPE")
    private String type;

    protected User() {
    }

    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (type != null ? !type.equals(user.type) : user.type != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
