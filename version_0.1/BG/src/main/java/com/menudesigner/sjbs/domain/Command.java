package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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

    //TODO to verify if the sql.time is the right import
    @Column(name = "order_time")
    private Time order_time;

    @Column(name = "table_no")
    private Integer table_no;

    @Column(name = "client_no")
    private Integer client_no;


    public Command() {
    }

    public Command(String title, String msg_extra, Date order_date, Time order_time, Integer table_no, Integer client_no) {
        this.title = title;
        this.msg_extra = msg_extra;
        this.order_date = order_date;
        this.order_time = order_time;
        this.table_no = table_no;
        this.client_no = client_no;
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
                '}';
    }
}
