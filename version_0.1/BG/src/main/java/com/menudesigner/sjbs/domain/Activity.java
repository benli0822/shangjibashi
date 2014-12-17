package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.domain.association.ActivityWithDish;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
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

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "description")
    @Size(max = 300)
    private String description;

    @OneToMany(mappedBy = "activity")
    private List<ActivityWithDish> dishes;

    public Activity() {
    }

    public Activity(String name, Time start_time, Time end_time, Date start_date, Date end_date, String description, List<ActivityWithDish> dishes) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.dishes = dishes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public List<ActivityWithDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<ActivityWithDish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", description='" + description + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
