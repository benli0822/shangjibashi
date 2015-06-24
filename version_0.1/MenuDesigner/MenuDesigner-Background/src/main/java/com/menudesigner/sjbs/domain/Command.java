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

  @Column(name = "price")
  private float price;

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

  @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<CommandActivity> activities = new HashSet<>();

  @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<CommandDish> dishes = new HashSet<>();

  //TODO really should consider the quantity problem, perhaps we go with JDBCTemplate
  @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<CommandMenu> menus = new HashSet<>();

  public Command() {
  }

  /**
   * Add an association between dish and command
   *
   * @param dish
   * @param quantity
   */
  public void addDish(Dish dish, int quantity) {
    CommandDish association = new CommandDish();
    association.setCommand(this);
    association.setDish(dish);
    association.setQuantity(quantity);

    this.dishes.add(association);
    dish.getCommands().add(association);
  }

  /**
   * Add an association between dish and activity
   *
   * @param activity
   * @param quantity
   */
  public void addActivity(Activity activity, int quantity) {
    CommandActivity association = new CommandActivity();
    association.setCommand(this);
    association.setActivity(activity);
    association.setQuantity(quantity);

    this.activities.add(association);
    activity.getCommands().add(association);
  }

  /**
   * Add an association between dish and activity
   *
   * @param menu
   * @param quantity
   */
  public void addMenu(Menu menu, int quantity) {
    CommandMenu association = new CommandMenu();
    association.setCommand(this);
    association.setMenu(menu);
    association.setQuantity(quantity);

    this.menus.add(association);
    menu.getCommands().add(association);
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

  public String getMsg_extra() {
    return msg_extra;
  }

  public void setMsg_extra(String msg_extra) {
    this.msg_extra = msg_extra;
  }

  public Date getOrder_date() {
    return order_date;
  }

  public void setOrder_date(Date order_date) {
    this.order_date = order_date;
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

  public Set<CommandActivity> getActivities() {
    return activities;
  }

  public void setActivities(Set<CommandActivity> activities) {
    this.activities = activities;
  }

  public Set<CommandDish> getDishes() {
    return dishes;
  }

  public void setDishes(Set<CommandDish> dishes) {
    this.dishes = dishes;
  }

  public Set<CommandMenu> getMenus() {
    return menus;
  }

  public void setMenus(Set<CommandMenu> menus) {
    this.menus = menus;
  }

  public float getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Command{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", price=" + price +
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

  public void setPrice(float price) {
    this.price = price;
  }

}
