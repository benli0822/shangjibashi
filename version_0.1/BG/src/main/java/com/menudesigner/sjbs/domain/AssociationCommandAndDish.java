package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "jb_command_dish")
public class AssociationCommandAndDish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Id
    @Column(name = "DISHID")
    private Integer dish_id;

    @Id
    @Column(name = "COMMANDID")
    private Integer command_id;

    @ManyToOne(optional = false, targetEntity = Dish.class)
    @PrimaryKeyJoinColumn(name = "DISHID", referencedColumnName = "ID")
    private Dish dish;

    @ManyToOne(optional = false, targetEntity = Command.class)
    @PrimaryKeyJoinColumn(name = "COMMANDID", referencedColumnName = "ID")
    private Command command;




}
