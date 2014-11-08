package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by JIN Benli on 31/10/14.
 */
@Entity
@Table(name = "md_activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Integer type;

    //TODO to verify if the sql.time is the right import
    @Column(name = "start_time")
    private Time start_time;

    //TODO to verify if the sql.time is the right import
    @Column(name = "end_time")
    private Time end_time;

    protected Activity() {}

}
