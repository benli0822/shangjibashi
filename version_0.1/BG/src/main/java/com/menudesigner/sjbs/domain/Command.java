package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "md_commands")
public class Command implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "table")
    private Integer table;

    @Column(name = "title")
    private String title;

    //TODO to verify if the sql.time is the right import
    @Column(name = "order_time")
    private Time order_time;

    @Column(name = "table_no")
    private Integer table_no;

    @Column(name = "client_no")
    private Integer client_no;

    @ManyToMany(mappedBy = "commands")
    private Set<Dish> dishes = new HashSet<Dish>();

    protected Command() {
    }

}
