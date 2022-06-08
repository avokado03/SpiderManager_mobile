package com.app.spidermanager.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.app.spidermanager.utils.Utils;

import java.util.Date;

/**
 * Модель для создания записи о пауке
 */
public class CreateSpiderModel {
    // Кличка, вид
    private String name, type;
    // Возраст (в линьках)
    private String age;
    // Фото
    private Drawable photo;
    // Пол
    private int sex;
    // Дата последнего кормления
    // Дата последней линьки
    private String lastFeedingDate, lastMoltingDate;

    public CreateSpiderModel(){};

    public CreateSpiderModel(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = Integer.toString(age);
        this.photo = null;
    }

    public CreateSpiderModel(String name, String type,
                             int sex, Date lastFeedingDate,
                             Date lastMoltingDate, int age) {
        this.name = name;
        this.type = type;
        this.photo = null;
        this.sex = sex;
        this.lastFeedingDate = Utils.dateToString(lastFeedingDate);
        this.lastMoltingDate = Utils.dateToString(lastMoltingDate);
        this.age = Integer.toString(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
