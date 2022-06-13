package com.app.spidermanager.models;

import java.util.ArrayList;

/**
 * Пауки
 */
public class SpiderListModel<SpiderItemModel>
        extends ListModelBase<com.app.spidermanager.models.SpiderItemModel> {

    public SpiderListModel(){super();}

    public SpiderListModel(ArrayList<com.app.spidermanager.models.SpiderItemModel> items){
        super(items);
    }

    public SpiderListModel(com.app.spidermanager.models.SpiderItemModel[] items){
        super(items);
    }

    @Override
    public void setItems(ArrayList<com.app.spidermanager.models.SpiderItemModel> items) {
        super.setItems(items);
    }

    @Override
    public ArrayList<com.app.spidermanager.models.SpiderItemModel> getItems() {
        return super.getItems();
    }
}
