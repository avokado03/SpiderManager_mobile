package com.app.spidermanager.models;

import android.graphics.drawable.Drawable;

/**
 * Модель для представления записи
 * о пауке в списке
 */
public class SpiderItemModel extends ModelWithId{
    // Кличка, вид, последняя дата кормления
    private final String name, type, feedingDate;
    // Фото
    private final byte[] photo;
    // Пол (иконка)
    private final Drawable sex;

    public SpiderItemModel(int id, String name, String type,
                           String feedingDate,
                           byte[] photo, Drawable sex) {
        super(id);
        this.name = name;
        this.type = type;
        this.feedingDate = feedingDate;
        this.photo = photo;
        this.sex = sex;
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
