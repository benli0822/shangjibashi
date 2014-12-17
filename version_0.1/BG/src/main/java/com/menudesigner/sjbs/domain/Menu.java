package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    @Size(max = 300)
    private String description;

    @Column(name = "start_time")
    private Time start_time;

    @Column(name = "end_time")
    private Time end_time;

    @Column(name = "start_date")
    private Time start_date;

    @Column(name = "end_date")
    private Time end_date;

    public Menu() {
    }

    public Menu(String name, String description, Time start_time, Time end_time, Time start_date, Time end_date) {
        this.name = name;
        this.description = description;
        this.start_time = start_time;
        this.end_time = end_time;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Time getStart_date() {
        return start_date;
    }

    public void setStart_date(Time start_date) {
        this.start_date = start_date;
    }

    public Time getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Time end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
