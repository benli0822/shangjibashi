package com.sjbs.menudesigner.background.domain;

import javax.persistence.*;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Entity
@Table(name = "md_command_menu")
public class CommandMenu {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "quantity")
  private int quantity;

  @ManyToOne
  @PrimaryKeyJoinColumn(name = "command_id", referencedColumnName = "id")
  private Command command;

  @ManyToOne
  @PrimaryKeyJoinColumn(name = "menu_id", referencedColumnName = "id")
  private Menu menu;

  public CommandMenu() {
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

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }
}
