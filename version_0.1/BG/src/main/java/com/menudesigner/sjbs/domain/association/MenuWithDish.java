package com.menudesigner.sjbs.domain.association;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Menu;

import javax.persistence.*;

/**
 * Created by JIN Benli on 17/12/14.
 */
@Entity
@Table(name = "md_menu_dish")
@IdClass(MenuWithDishId.class)
public class MenuWithDish {

    @Id
    private long dish_id;

    @Id
    private long menu_id;

    @ManyToOne
    @JoinColumn(name = "md_dish_key", referencedColumnName = "id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "md_menu_key",  referencedColumnName = "id")
    private Menu menu;


}
