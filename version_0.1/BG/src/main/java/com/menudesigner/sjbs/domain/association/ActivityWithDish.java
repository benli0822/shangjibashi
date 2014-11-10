package com.menudesigner.sjbs.domain.association;

import com.menudesigner.sjbs.domain.Activity;
import com.menudesigner.sjbs.domain.Dish;

import javax.persistence.*;

/**
 * Created by JIN Benli on 08/11/14.
 */
@Entity
@Table(name = "md_activity_dish")
@IdClass(ActivityWithDishId.class)
public class ActivityWithDish {

    @Id
    private long dish_id;

    @Id
    private long activity_id;

    @ManyToOne
    @JoinColumn(name = "ad_activity_key", updatable = false, insertable = false, referencedColumnName = "id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "ad_dish_key", updatable = false, insertable = false, referencedColumnName = "id")
    private Activity activity;
}


