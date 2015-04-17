package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JIN Benli on 17/12/14.
 */
@Entity
@Table(name = "md_types")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "is_firstmenu")
    private boolean is_firstmenu;

    @Column(name = "is_secondmenu")
    private boolean is_secondmenu;

    @Column(name = "firstmenu_id")
    private long firstmenu_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_for_customize")
    private boolean is_for_customize;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "md_dish_type",
            joinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")})
    private Set<Dish> dishes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "md_conflict_dish_type",
            joinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "conflict_id", referencedColumnName = "id")})
    private Set<Type> conflictTypes = new HashSet<>();

    public Type() {
    }

    public Type(boolean is_firstmenu, boolean is_secondmenu, long firstmenu_id, String name, String description,
                boolean is_for_customize, Set<Dish> dishes, Set<Type> conflictTypes) {
        this.is_firstmenu = is_firstmenu;
        this.is_secondmenu = is_secondmenu;
        this.firstmenu_id = firstmenu_id;
        this.name = name;
        this.description = description;
        this.is_for_customize = is_for_customize;
        this.dishes = dishes;
        this.conflictTypes = conflictTypes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIs_firstmenu() {
        return is_firstmenu;
    }

    public void setIs_firstmenu(boolean is_firstmenu) {
        this.is_firstmenu = is_firstmenu;
    }

    public boolean isIs_secondmenu() {
        return is_secondmenu;
    }

    public void setIs_secondmenu(boolean is_secondmenu) {
        this.is_secondmenu = is_secondmenu;
    }

    public long getFirstmenu_id() {
        return firstmenu_id;
    }

    public void setFirstmenu_id(long firstmenu_id) {
        this.firstmenu_id = firstmenu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_for_customize() {
        return is_for_customize;
    }

    public void setIs_for_customize(boolean is_for_customize) {
        this.is_for_customize = is_for_customize;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
        //TODO notice that here add into dish will give duplicate res in mysql
        dish.addType(this);
    }

    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
    }

    public Set<Type> getConflictTypes() {
        return conflictTypes;
    }

    public void setConflictTypes(Set<Type> conflictTypes) {
        this.conflictTypes = conflictTypes;
    }

    public void addConflictType(Type type) {
        this.conflictTypes.add(type);
    }

    public void removeConflictType(Type type) {
        this.conflictTypes.remove(type);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", is_firstmenu=" + is_firstmenu +
                ", is_secondmenu=" + is_secondmenu +
                ", firstmenu_id=" + firstmenu_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_for_customize=" + is_for_customize +
                ", conflictTypes=" + conflictTypes +
                '}';
    }
}
