package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.domain.association.ActivityWithDish;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

/**
 * Created by JIN Benli on 31/10/14.
 */
@Entity
@Table(name = "md_activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    //TODO to verify if the sql.time is the right import
    @Column(name = "start_time")
    private Time start_time;

    //TODO to verify if the sql.time is the right import
    @Column(name = "end_time")
    private Time end_time;

    @OneToMany(mappedBy = "activity")
    private List<ActivityWithDish> dishes;

    protected Activity() {}

    public Activity(String name, Time start_time, Time end_time) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<ActivityWithDish> getDishes() {
        return dishes;
    }

}
