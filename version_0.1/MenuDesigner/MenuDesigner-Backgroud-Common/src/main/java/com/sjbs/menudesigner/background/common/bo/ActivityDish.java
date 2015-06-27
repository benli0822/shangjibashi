package com.sjbs.menudesigner.background.common.bo;

import javax.persistence.*;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Entity
@Table(name = "md_activity_dish")
public class ActivityDish {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "quantity")
  private int quantity;

  @ManyToOne
  @PrimaryKeyJoinColumn(name = "activity_id", referencedColumnName = "id")
  private Activity activity;

  @ManyToOne
  @PrimaryKeyJoinColumn(name = "dish_id", referencedColumnName = "id")
  private Dish dish;

  public ActivityDish() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public Dish getDish() {
    return dish;
  }

  public void setDish(Dish dish) {
    this.dish = dish;
  }
}
