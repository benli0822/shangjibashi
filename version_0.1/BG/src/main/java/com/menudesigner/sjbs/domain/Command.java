package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "md_command")
public class Command implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "msg_extra")
    @Size(max = 150)
    private String msg_extra;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "order_time")
    private Time order_time;

    @Column(name = "table_no")
    private Integer table_no;

    @Column(name = "client_no")
    private Integer client_no;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "md_command_activity",
            joinColumns = {@JoinColumn(name = "command_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_id", referencedColumnName = "id")})
    private Set<Activity> activities = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "md_command_dish",
            joinColumns = {@JoinColumn(name = "command_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
    private Set<Dish> dishes = new HashSet<>();

    //TODO really should consider the quantity problem, perhaps we go with JDBCTemplate
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "md_command_menu",
            joinColumns = {@JoinColumn(name = "command_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
    private Set<Menu> menus = new HashSet<>();

    public Command() {
    }

    public Command(String title, String msg_extra, Date order_date, Time order_time, Integer table_no, Integer client_no, Set<Activity> activities, Set<Dish> dishes, Set<Menu> menus) {
        this.title = title;
        this.msg_extra = msg_extra;
        this.order_date = order_date;
        this.order_time = order_time;
        this.table_no = table_no;
        this.client_no = client_no;
        this.activities = activities;
        this.dishes = dishes;
        this.menus = menus;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getMsg_extra() {
        return msg_extra;
    }

    public void setMsg_extra(String msg_extra) {
        this.msg_extra = msg_extra;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public Integer getTable_no() {
        return table_no;
    }

    public void setTable_no(Integer table_no) {
        this.table_no = table_no;
    }

    public Integer getClient_no() {
        return client_no;
    }

    public void setClient_no(Integer client_no) {
        this.client_no = client_no;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
        dish.addCommand(this);
    }

    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public void removeMenu(Menu menu) {
        this.menus.remove(menu);
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", msg_extra='" + msg_extra + '\'' +
                ", order_date=" + order_date +
                ", order_time=" + order_time +
                ", table_no=" + table_no +
                ", client_no=" + client_no +
                ", activities=" + activities +
                ", dishes=" + dishes +
                ", menus=" + menus +
                '}';
    }
}
