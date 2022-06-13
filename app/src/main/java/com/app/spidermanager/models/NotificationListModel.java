package com.app.spidermanager.models;

import java.util.ArrayList;

/**
 * Оповещения
 */
public class NotificationListModel extends ListModelBase<NotificationItemModel>{

    public NotificationListModel(){super();}

    public NotificationListModel(ArrayList<NotificationItemModel> items){
        super(items);
    }

    public NotificationListModel(NotificationItemModel[] items){
        super(items);
    }

    @Override
    public void setItems(ArrayList<NotificationItemModel> items) {
        super.setItems(items);
    }

    @Override
    public ArrayList<NotificationItemModel> getItems() {
        return super.getItems();
    }
}
