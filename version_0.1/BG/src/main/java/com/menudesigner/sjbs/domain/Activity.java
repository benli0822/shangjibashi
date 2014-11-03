package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by JIN Benli on 31/10/14.
 */
@Entity
@Table(name = "jb_activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private Integer type;

    @Column(name = "START_TIME")
    private Time start_time;

    @Column(name = "END_TIME")
    private Time end_time;

    protected Activity() {}

    public Activity(String name, Integer type, Time start_time, Time end_time) {
        this.name = name;
        this.type = type;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;

        Activity activity = (Activity) o;

        if (end_time != null ? !end_time.equals(activity.end_time) : activity.end_time != null) return false;
        if (!id.equals(activity.id)) return false;
        if (name != null ? !name.equals(activity.name) : activity.name != null) return false;
        if (start_time != null ? !start_time.equals(activity.start_time) : activity.start_time != null) return false;
        if (type != null ? !type.equals(activity.type) : activity.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (start_time != null ? start_time.hashCode() : 0);
        result = 31 * result + (end_time != null ? end_time.hashCode() : 0);
        return result;
    }
}
