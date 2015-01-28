package com.menudesigner.sjbs.rest.wrapper;

/**
 * Created by JIN Benli on 28/01/15.
 */
public class ActivityWrapper {
    long activity_id;
    int quantity;

    public ActivityWrapper() {
    }

    public long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(long activity_id) {
        this.activity_id = activity_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
