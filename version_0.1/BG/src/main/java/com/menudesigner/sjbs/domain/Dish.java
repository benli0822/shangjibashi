package com.menudesigner.sjbs.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "md_dish")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotNull(message = "{dish.notNull.message}")
    @NotBlank(message = "{dish.notNull.message}")
//    @Size(min=2, max=30, message = "{dish.notNull.message}")
    @Column(name = "name")
    private String name;

    @Column(name = "is_typed")
    private Boolean is_typed = false;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    @Size(max = 300)
    private String description;

    @Column(name = "disabled")
    private Boolean disabled = false;

    //TODO to verify if the sql.time is the right import
    @Column(name = "start_time")
    private Time start_time;

    //TODO to verify if the sql.time is the right import
    @Column(name = "end_time")
    private Time end_time;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @OneToMany(mappedBy = "dish", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ActivityDish> activities = new HashSet<>();

    @OneToMany(mappedBy = "dish", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CommandDish> commands = new HashSet<>();

    @OneToMany(mappedBy = "dish", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MenuDish> menus = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "md_dish_type",
            joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "id")})
    private Set<Type> types = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "md_file_dish",
            joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "file_id", referencedColumnName = "id")})
    private Set<File> files = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "md_dish_option",
            joinColumns = {@JoinColumn(name = "dish_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")})
    private Set<Option> options = new HashSet<>();

    public Dish() {
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_typed() {
        return is_typed;
    }

    public void setIs_typed(Boolean is_typed) {
        this.is_typed = is_typed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public long getId() {
        return id;
    }

    public Set<ActivityDish> getActivities() {
        return activities;
    }

    public void setActivities(Set<ActivityDish> activities) {
        this.activities = activities;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void addActivity(ActivityDish activity) {
        this.activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activities.remove(activity);
    }

    public Set<CommandDish> getCommands() {
        return commands;
    }

    public void setCommands(Set<CommandDish> commands) {
        this.commands = commands;
    }

    public Set<MenuDish> getMenus() {
        return menus;
    }

    public void setMenus(Set<MenuDish> menus) {
        this.menus = menus;
    }

    public void addMenu(MenuDish menu) {
        this.menus.add(menu);
    }

    public void removeMenu(Menu menu) {
        this.menus.remove(menu);
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public void addType(Type type) {
        this.types.add(type);
    }

    public void removeType(Type type) {
        this.types.remove(type);
    }

    public void addOption(Option option) {
        this.options.add(option);
    }

    public void removeOption(Option option) {
        this.options.remove(option);
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public void addFile(File file) {
        this.files.add(file);
    }

    public void removeFile(File file) {
        this.files.remove(file);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_typed=" + is_typed +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", disabled=" + disabled +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", activities=" + activities +
                ", commands=" + commands +
                ", menus=" + menus +
                ", types=" + types +
                ", files=" + files +
                ", options=" + options +
                '}';
    }
}
