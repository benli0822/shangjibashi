package com.menudesigner.sjbs.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by JIN Benli on 03/11/14.
 */
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_BASIC")
    private Boolean is_basic;

    protected Type() {
    }

    public Type(String name, Boolean is_basic) {
        this.name = name;
        this.is_basic = is_basic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_basic() {
        return is_basic;
    }

    public void setIs_basic(Boolean is_basic) {
        this.is_basic = is_basic;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_basic=" + is_basic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;

        Type type = (Type) o;

        if (!id.equals(type.id)) return false;
        if (is_basic != null ? !is_basic.equals(type.is_basic) : type.is_basic != null) return false;
        if (name != null ? !name.equals(type.name) : type.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (is_basic != null ? is_basic.hashCode() : 0);
        return result;
    }
}
