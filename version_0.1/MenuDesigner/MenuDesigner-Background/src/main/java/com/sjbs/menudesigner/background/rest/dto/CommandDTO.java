package com.sjbs.menudesigner.background.rest.dto;

import java.util.Map;

/**
 * Created by JIN Benli on 28/01/15.
 */
public class CommandDTO {
  int table_no;
  int client_no;
  int price; //TODO add to db
  String title;
  String msg_extra;

  Map<String, String> dish_dictionary;
  Map<String, String> menu_dictionary;
  Map<String, String> activity_dictionary;

  public CommandDTO() {
  }

  public int getTable_no() {
    return table_no;
  }

  public void setTable_no(int table_no) {
    this.table_no = table_no;
  }

  public int getClient_no() {
    return client_no;
  }

  public void setClient_no(int client_no) {
    this.client_no = client_no;
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

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Map<String, String> getDish_dictionary() {
    return dish_dictionary;
  }

  public void setDish_dictionary(Map<String, String> dish_dictionary) {
    this.dish_dictionary = dish_dictionary;
  }

  public Map<String, String> getMenu_dictionary() {
    return menu_dictionary;
  }

  public void setMenu_dictionary(Map<String, String> menu_dictionary) {
    this.menu_dictionary = menu_dictionary;
  }

  public Map<String, String> getActivity_dictionary() {
    return activity_dictionary;
  }

  public void setActivity_dictionary(Map<String, String> activity_dictionary) {
    this.activity_dictionary = activity_dictionary;
  }

  @Override
  public String toString() {
    return "CommandWrapper{" +
        "table_no=" + table_no +
        ", client_no=" + client_no +
        ", price=" + price +
        ", title='" + title + '\'' +
        ", msg_extra='" + msg_extra + '\'' +
        ", dish_dictionary=" + dish_dictionary +
        ", menu_dictionary=" + menu_dictionary +
        ", activity_dictionary=" + activity_dictionary +
        '}';
  }
}
