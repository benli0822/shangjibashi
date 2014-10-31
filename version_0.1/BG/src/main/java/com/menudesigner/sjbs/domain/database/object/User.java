package com.menudesigner.sjbs.domain.database.object;

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
        return String.format(
                "User[id=%d, username='%s', password='%s', type='%s']",
                id, username, password, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        User user = (User) obj;

        return !(this.id != null ? !this.id.equals(user.id) : user.id != null);

    }
}
