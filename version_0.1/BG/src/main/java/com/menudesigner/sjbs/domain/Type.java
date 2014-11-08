package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "md_type")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_basic")
    private Boolean is_basic;

    @Column(name = "group")
    private Integer group;

    protected Type() {
    }
}
