package com.jboilerplate.events;

/**
 * Created by user on 12/3/2017.
 */

public class DrawerItem {
    private int id;
    private int itemIconId;
    private String itemTitle;

    public DrawerItem(int id, int itemIconId, String itemTitle) {
        this.id = id;
        this.itemIconId = itemIconId;
        this.itemTitle = itemTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemIconId() {
        return itemIconId;
    }

    public void setItemIconId(int itemIconId) {
        this.itemIconId = itemIconId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
