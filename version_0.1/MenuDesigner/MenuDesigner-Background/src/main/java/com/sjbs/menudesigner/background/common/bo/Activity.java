package com.sjbs.menudesigner.background.common.bo;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * A promotion activity entity.
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

  @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<CommandActivity> commands = new HashSet<>();

  @OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<ActivityDish> dishes = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "activities")
  private Set<File> files = new HashSet<>();

  public Activity() {
  }

  /**
   * Add an association between dish and activity
   *
   * @param dish
   * @param quantity
   */
  public void addDish(Dish dish, int quantity) {
    ActivityDish association = new ActivityDish();
    association.setActivity(this);
    association.setDish(dish);
    association.setQuantity(quantity);

    this.dishes.add(association);
    dish.getActivities().add(association);
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<CommandActivity> getCommands() {
    return commands;
  }

  public void setCommands(Set<CommandActivity> commands) {
    this.commands = commands;
  }

  public Set<ActivityDish> getDishes() {
    return dishes;
  }

  public void setDishes(Set<ActivityDish> dishes) {
    this.dishes = dishes;
  }

  public Set<File> getFiles() {
    return files;
  }

  public void setFiles(Set<File> files) {
    this.files = files;
  }

  public void addFile(File file) {
    this.files.add(file);
  }

  public void removeFile(File file) {
    this.files.remove(file);
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
        ", commands=" + commands +
        ", dishes=" + dishes +
        ", files=" + files +
        '}';
  }

}
