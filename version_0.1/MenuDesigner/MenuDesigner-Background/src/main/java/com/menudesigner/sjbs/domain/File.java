package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JIN Benli on 28/12/14.
 */
@Entity
@Table(name = "md_file")
public class File implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "location")
  private String location;

  @Column(name = "size")
  private long size;

  @Column(name = "type")
  private String type;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "md_file_dish",
      joinColumns = {@JoinColumn(name = "file_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
  private Set<Dish> dishes = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "md_file_menu",
      joinColumns = {@JoinColumn(name = "file_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
  private Set<Menu> menus = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "md_file_activity",
      joinColumns = {@JoinColumn(name = "file_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "activity_id", referencedColumnName = "id")})
  private Set<Activity> activities = new HashSet<>();

  public File() {
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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Set<Dish> getDishes() {
    return dishes;
  }

  public void setDishes(Set<Dish> dishes) {
    this.dishes = dishes;
  }

  public void addDish(Dish dish) {
    this.dishes.add(dish);
    dish.addFile(this);
  }

  public void removeDish(Dish dish) {
    this.dishes.remove(dish);
    dish.removeFile(this);
  }

  public Set<Menu> getMenus() {
    return menus;
  }

  public void setMenus(Set<Menu> menus) {
    this.menus = menus;
  }

  public void addMenu(Menu menu) {
    this.menus.add(menu);
    menu.addFile(this);
  }

  public void removeMenu(Menu menu) {
    this.menus.remove(menu);
    menu.removeFile(this);
  }

  public Set<Activity> getActivities() {
    return activities;
  }

  public void setActivities(Set<Activity> activities) {
    this.activities = activities;
  }

  public void addActivity(Activity activity) {
    this.activities.add(activity);
    activity.addFile(this);
  }

  public void removeActivity(Activity activity) {
    this.activities.remove(activity);
    activity.removeFile(this);
  }

  @Override
  public String toString() {
    return "File{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", location='" + location + '\'' +
        ", size=" + size +
        ", type='" + type + '\'' +
        ", dishes=" + dishes +
        ", menus=" + menus +
        ", activities=" + activities +
        '}';
  }
}
