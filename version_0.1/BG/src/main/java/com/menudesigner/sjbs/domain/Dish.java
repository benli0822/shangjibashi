package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "jb_dish")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_id")
    private Integer type_id;

    @Column(name = "is_typed")
    private Boolean is_typed;

    @Column(name = "img_path")
    private String img_path;

    @Column(name = "description")
    private String description;

    @Column(name = "disabled")
    private Boolean disabled;

    //TODO to verify if the sql.time is the right import
    @Column(name = "start_time")
    private Time start_time;

    //TODO to verify if the sql.time is the right import
    @Column(name = "end_time")
    private Time end_time;

    protected Dish() {
    }
}
