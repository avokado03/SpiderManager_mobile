package com.app.spidermanager.models;

import com.app.spidermanager.utils.Utils;

import java.util.Date;

/**
 * Модель для создания записи о пауке
 */
public class CreateSpiderModel {
    // Кличка, вид
    private String name, type;
    // Возраст (в линьках)
    private int age;
    // Фото
    private byte[] photo;
    // Пол
    private Boolean sex;
    // Дата последнего кормления
    // Дата последней линьки
    private Date lastFeedingDate, lastMoltingDate;

    public CreateSpiderModel(){};

    public CreateSpiderModel(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public CreateSpiderModel(String name, String type, byte[] photo,
                             Boolean sex, Date lastFeedingDate,
                             Date lastMoltingDate, int age) {
        this.name = name;
        this.type = type;
        this.photo = photo;
        this.sex = sex;
        this.lastFeedingDate = lastFeedingDate;
        this.lastMoltingDate = lastMoltingDate;
        this.age = age;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getLastFeedingDate() {
        return Utils.dateToString(lastFeedingDate);
    }

    public void setLastFeedingDate(Date lastFeedingDate) {
        this.lastFeedingDate = lastFeedingDate;
    }

    public Date getLastMoltingDate() {
        return lastMoltingDate;
    }

    public void setLastMoltingDate(Date lastMoltingDate) {
        this.lastMoltingDate = lastMoltingDate;
    }
}
