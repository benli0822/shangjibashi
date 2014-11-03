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
        return String.format("Activity[id=%d, name='%s', type='%d', startTime='%s', endTime='%s']", id, name, type, start_time.toString(), end_time.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Activity activity = (Activity) obj;

        return !(this.id != null ? !this.id.equals(activity.id) : activity.id != null);
    }
}
