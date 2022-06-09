package com.app.spidermanager.models;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ListModelBase<I extends ModelWithId> {

    private ArrayList<I> items;

    public ListModelBase(){}

    public ListModelBase(ArrayList<I> items) {
        this.items = items;
    }

    public ListModelBase(I[] items){
        this.items = new ArrayList<I>(Arrays.asList(items));
    }

    public ArrayList<I> getItems() {
        return items;
    }

    public void setItems(ArrayList<I> items) {
        this.items = items;
    }
}
