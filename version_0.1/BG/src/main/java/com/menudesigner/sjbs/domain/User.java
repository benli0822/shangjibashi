package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JIN Benli on 12/10/14.
 */
@Entity
@Table(name = "md_user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String username;

    @Column(name = "passwd")
    private String password;

    @Column(name = "type")
    private String type;

    protected User() {
    }
}
