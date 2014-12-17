package com.menudesigner.sjbs.domain;

import com.menudesigner.sjbs.domain.association.ActivityWithDish;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "md_dish")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_typed")
    private Boolean is_typed;

    @Column(name = "img_path")
    private String img_path;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    @Size(max = 300)
    private String description;

    @Column(name = "disabled")
    private Boolean disabled;

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

    @OneToMany(mappedBy = "dish")
    private List<ActivityWithDish> activities;

    public Dish() {
    }

    public Dish(String name, Boolean is_typed, String img_path, int price, String description, Boolean disabled, Time start_time, Time end_time, Date start_date, Date end_date, List<ActivityWithDish> activities) {
        this.name = name;
        this.is_typed = is_typed;
        this.img_path = img_path;
        this.price = price;
        this.description = description;
        this.disabled = disabled;
        this.start_time = start_time;
        this.end_time = end_time;
        this.start_date = start_date;
        this.end_date = end_date;
        this.activities = activities;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setActivities(List<ActivityWithDish> activities) {
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_typed() {
        return is_typed;
    }

    public void setIs_typed(Boolean is_typed) {
        this.is_typed = is_typed;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
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

    public long getId() {
        return id;
    }

    public List<ActivityWithDish> getActivities() {
        return activities;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "activities=" + activities +
                ", end_time=" + end_time +
                ", start_time=" + start_time +
                ", disabled=" + disabled +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", img_path='" + img_path + '\'' +
                ", is_typed=" + is_typed +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
