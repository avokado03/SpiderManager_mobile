package com.app.spidermanager.models;

import android.graphics.drawable.Drawable;

import com.app.spidermanager.utils.Utils;

import java.util.Date;

/**
 * Модель для обновления записи
 * о пауке
 */
public class UpdSpiderModel extends ModelWithId{
    // Возраст
    // Кличка, вид
    private String age, name, type;
    // Фото
    private Drawable photo;
    // Пол
    private int sex;
    // Дата последнего кормления, дата последней линьки
    private String lastFeedingDate, lastMoltingDate;


    public UpdSpiderModel(int id, String age, String name, String type,
                          Drawable photo, int sex,
                          Date lastFeedingDate, Date lastMoltingDate) {
        super(id);
        this.age = age;
        this.name = name;
        this.type = type;
        this.photo = photo;
        this.sex = sex;
        this.lastFeedingDate = Utils.dateToString(lastFeedingDate);
        this.lastMoltingDate = Utils.dateToString(lastMoltingDate);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public String getLastFeedingDate() {
        return lastFeedingDate;
    }

    public void setLastFeedingDate(String lastFeedingDate) {
        this.lastFeedingDate = lastFeedingDate;
    }

    public String getLastMoltingDate() {
        return lastMoltingDate;
    }

    public void setLastMoltingDate(String lastMoltingDate) {
        this.lastMoltingDate = lastMoltingDate;
    }
}
