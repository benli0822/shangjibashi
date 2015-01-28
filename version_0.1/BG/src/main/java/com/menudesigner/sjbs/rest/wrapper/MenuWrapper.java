package com.menudesigner.sjbs.rest.wrapper;

/**
 * Created by JIN Benli on 28/01/15.
 */
public class MenuWrapper {
    long menu_id;
    int quantity;

    public MenuWrapper() {
    }

    public long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(long menu_id) {
        this.menu_id = menu_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
