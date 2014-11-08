package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by JIN Benli on 08/11/14.
 */
@Entity
@Table(name = "md_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private Integer name;

    @Column(name = "start_time")
    private Time start_time;

    @Column(name = "end_time")
    private Time end_time;

    protected Menu() {
    }
}
