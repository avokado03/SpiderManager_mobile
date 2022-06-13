package com.app.spidermanager.models;

import android.graphics.drawable.Drawable;

/**
 * Модель для представления записи
 * о пауке в списке
 */
public class SpiderItemModel extends ModelWithId{
    // Кличка, вид, дата последнего кормления, дата последней линьки
    private String name, type, feedingDate, moltingDate;
    // Фото
    private Drawable photo;
    // Пол
    private int sex;
    // Возраст
    private int age;

    public SpiderItemModel(int id, String name, int age, String type,
                           String feedingDate,
                           String moltingDate, int sex) {
        super(id);
        this.name = name;
        this.age = age;
        this.type = type;
        this.feedingDate = feedingDate;
        this.moltingDate = moltingDate;
        this.photo = null;
        this.sex = sex;
    }

    public SpiderItemModel(int id, String name, int age, String type,
                           String feedingDate, Drawable photo,
                           String moltingDate, int sex) {
        super(id);
        this.name = name;
        this.age = age;
        this.type = type;
        this.feedingDate = feedingDate;
        this.moltingDate = moltingDate;
        this.photo = photo;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeedingDate() {
        return feedingDate;
    }

    public void setFeedingDate(String feedingDate) {
        this.feedingDate = feedingDate;
    }

    public String getMoltingDate() {
        return moltingDate;
    }

    public void setMoltingDate(String moltingDate) {
        this.moltingDate = moltingDate;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
