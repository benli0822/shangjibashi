package com.sjbs.menudesigner.background.domain;

import javax.persistence.*;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Entity
@Table(name = "md_command_dish")
public class CommandDish {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "quantity")
  private int quantity;

  @ManyToOne
  @PrimaryKeyJoinColumn(name = "command_id", referencedColumnName = "id")
  private Command command;

  @ManyToOne
  @PrimaryKeyJoinColumn(name = "dish_id", referencedColumnName = "id")
  private Dish dish;

  public CommandDish() {
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

  public Command getCommand() {
    return command;
  }

  public void setCommand(Command command) {
    this.command = command;
  }

  public Dish getDish() {
    return dish;
  }

  public void setDish(Dish dish) {
    this.dish = dish;
  }
}
