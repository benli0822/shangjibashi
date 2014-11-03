package com.menudesigner.sjbs.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by JIN Benli on 03/11/14.
 */
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    //TODO what's the difference between type and type_id?
    @Column(name = "TYPE")
    private Integer type;

    @Column(name = "IS_TYPED")
    private Boolean is_typed;

    @Column(name = "TYPE_ID")
    private Integer type_id;

    @Column(name = "IMG_PATH")
    private String img_path;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DISABLED")
    private Boolean disabled;

    @Column(name = "START_TIME")
    private Time start_time;

    @Column(name = "END_TIME")
    private Time end_time;

    protected Dish() {
    }

    public Dish(String name, Integer type, Boolean is_typed, Integer type_id, String img_path, String description, Boolean disabled, Time start_time, Time end_time) {
        this.name = name;
        this.type = type;
        this.is_typed = is_typed;
        this.type_id = type_id;
        this.img_path = img_path;
        this.description = description;
        this.disabled = disabled;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getIs_typed() {
        return is_typed;
    }

    public void setIs_typed(Boolean is_typed) {
        this.is_typed = is_typed;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
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

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", is_typed=" + is_typed +
                ", type_id=" + type_id +
                ", img_path='" + img_path + '\'' +
                ", description='" + description + '\'' +
                ", disabled=" + disabled +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;

        Dish dish = (Dish) o;

        if (description != null ? !description.equals(dish.description) : dish.description != null) return false;
        if (disabled != null ? !disabled.equals(dish.disabled) : dish.disabled != null) return false;
        if (end_time != null ? !end_time.equals(dish.end_time) : dish.end_time != null) return false;
        if (!id.equals(dish.id)) return false;
        if (img_path != null ? !img_path.equals(dish.img_path) : dish.img_path != null) return false;
        if (is_typed != null ? !is_typed.equals(dish.is_typed) : dish.is_typed != null) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (start_time != null ? !start_time.equals(dish.start_time) : dish.start_time != null) return false;
        if (type != null ? !type.equals(dish.type) : dish.type != null) return false;
        if (type_id != null ? !type_id.equals(dish.type_id) : dish.type_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (is_typed != null ? is_typed.hashCode() : 0);
        result = 31 * result + (type_id != null ? type_id.hashCode() : 0);
        result = 31 * result + (img_path != null ? img_path.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (start_time != null ? start_time.hashCode() : 0);
        result = 31 * result + (end_time != null ? end_time.hashCode() : 0);
        return result;
    }
}
