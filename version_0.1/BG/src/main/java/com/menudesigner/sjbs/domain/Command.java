package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "jb_commands")
public class Command implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "TABLE")
    private Integer tb_nb;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DISH_ID")
    private Integer dish_id;

    @Column(name = "MENU_ID")
    private Integer menu_id;

    @Column(name = "ORDER_TIME")
    private Time order_time;


}
