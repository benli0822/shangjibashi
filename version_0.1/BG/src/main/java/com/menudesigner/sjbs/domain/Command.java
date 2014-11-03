package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "jb_commands")
public class Command implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //TODO should consider the difference between table and table nb
    @Column(name = "TABLE")
    private Integer table;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DISH_ID")
    private Integer dish_id;

    @Column(name = "MENU_ID")
    private Integer menu_id;

    @Column(name = "ORDER_TIME")
    private Time order_time;

    @Column(name = "TABLE_NB")
    private Integer table_nb;

    @Column(name = "CLIENT_NB")
    private Integer client_nb;

    protected Command() {}

    public Command(Integer table, String title, Integer dish_id, Integer menu_id, Time order_time, Integer table_nb, Integer client_nb) {
        this.table = table;
        this.title = title;
        this.dish_id = dish_id;
        this.menu_id = menu_id;
        this.order_time = order_time;
        this.table_nb = table_nb;
        this.client_nb = client_nb;
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDish_id() {
        return dish_id;
    }

    public void setDish_id(Integer dish_id) {
        this.dish_id = dish_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public Integer getTable_nb() {
        return table_nb;
    }

    public void setTable_nb(Integer table_nb) {
        this.table_nb = table_nb;
    }

    public Integer getClient_nb() {
        return client_nb;
    }

    public void setClient_nb(Integer client_nb) {
        this.client_nb = client_nb;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", table=" + table +
                ", title='" + title + '\'' +
                ", dish_id=" + dish_id +
                ", menu_id=" + menu_id +
                ", order_time=" + order_time +
                ", table_nb=" + table_nb +
                ", client_nb=" + client_nb +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;

        Command command = (Command) o;

        if (client_nb != null ? !client_nb.equals(command.client_nb) : command.client_nb != null) return false;
        if (dish_id != null ? !dish_id.equals(command.dish_id) : command.dish_id != null) return false;
        if (!id.equals(command.id)) return false;
        if (menu_id != null ? !menu_id.equals(command.menu_id) : command.menu_id != null) return false;
        if (order_time != null ? !order_time.equals(command.order_time) : command.order_time != null) return false;
        if (table != null ? !table.equals(command.table) : command.table != null) return false;
        if (table_nb != null ? !table_nb.equals(command.table_nb) : command.table_nb != null) return false;
        if (title != null ? !title.equals(command.title) : command.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (table != null ? table.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (dish_id != null ? dish_id.hashCode() : 0);
        result = 31 * result + (menu_id != null ? menu_id.hashCode() : 0);
        result = 31 * result + (order_time != null ? order_time.hashCode() : 0);
        result = 31 * result + (table_nb != null ? table_nb.hashCode() : 0);
        result = 31 * result + (client_nb != null ? client_nb.hashCode() : 0);
        return result;
    }
}
