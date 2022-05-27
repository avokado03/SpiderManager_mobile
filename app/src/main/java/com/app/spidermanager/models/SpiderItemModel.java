package com.app.spidermanager.models;

import android.graphics.drawable.Drawable;

public class SpiderItemModel {
    private final String name, type, feedingDate;
    private final byte[] photo;
    private final Drawable sex;

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

    public SpiderItemModel(String name, String type,
                           String feedingDate,
                           byte[] photo, Drawable sex) {
        this.name = name;
        this.type = type;
        this.feedingDate = feedingDate;
        this.photo = photo;
        this.sex = sex;
    }
}
