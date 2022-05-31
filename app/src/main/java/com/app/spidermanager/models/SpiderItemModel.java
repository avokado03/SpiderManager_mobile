package com.app.spidermanager.models;

import android.graphics.drawable.Drawable;

public class SpiderItemModel {
    private final int id;
    private final String name, type, feedingDate;
    private final byte[] photo;
    private final Drawable sex;

    public SpiderItemModel(int id, String name, String type,
                           String feedingDate,
                           byte[] photo, Drawable sex) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.feedingDate = feedingDate;
        this.photo = photo;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFeedingDate() {
        return feedingDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Drawable getSex() {
        return sex;
    }
}
