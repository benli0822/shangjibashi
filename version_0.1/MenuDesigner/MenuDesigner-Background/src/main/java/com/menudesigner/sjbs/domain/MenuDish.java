package com.menudesigner.sjbs.domain;

import javax.persistence.*;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Entity
@Table(name = "md_menu_dish")
public class MenuDish
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "dish_id", referencedColumnName = "id")
    private Dish dish;

    public MenuDish()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    public Dish getDish()
    {
        return dish;
    }

    public void setDish(Dish dish)
    {
        this.dish = dish;
    }
}
