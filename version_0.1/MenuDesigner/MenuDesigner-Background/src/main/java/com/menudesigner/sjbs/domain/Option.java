package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JIN Benli on 20/12/14.
 */
@Entity
@Table(name = "md_options")
public class Option implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "md_dish_option",
      joinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
  private Set<Dish> dishes = new HashSet<>();

  public Option() {
  }

  public Option(String name, Set<Dish> dishes) {
    this.name = name;
    this.dishes = dishes;
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

  public Set<Dish> getDishes() {
    return dishes;
  }

  public void setDishes(Set<Dish> dishes) {
    this.dishes = dishes;
  }

  public void addDish(Dish dish) {
    this.dishes.add(dish);
    dish.addOption(this);
  }

  public void removeDish(Dish dish) {
    this.dishes.remove(dish);
  }

  @Override
  public String toString() {
    return "Option{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", dishes=" + dishes +
        '}';
  }
}
