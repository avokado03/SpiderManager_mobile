package com.app.models;

import java.util.Date;

/**
 * Модель "Паук"
 */
public class Spider {
    //Id
    private final int spiderId;
    //Кличка
    private String name;
    //Возраст (в линьках)
    private int age;
    // Биологический вид
    private String type;

    // Фото
    private byte[] photo;
    //Пол
    private Boolean sex;
    // Дата последней кормежки
    private Date lastFeedingDate;
    // Дата последней линьки
    private Date lastMoltingDate;

    public Spider(int spiderId, String name, int age, String type,
                  byte[] photo, Boolean sex, Date lastFeedingDate,
                  Date lastMoltingDate) {
        this.spiderId = spiderId;
        this.name = name;
        this.age = age;
        this.type = type;
        this.photo = photo;
        this.sex = sex;
        this.lastFeedingDate = lastFeedingDate;
        this.lastMoltingDate = lastMoltingDate;
    }

    public int getSpiderId() {
        return spiderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Boolean getSex() {
        return sex;
    }

    public Date getLastFeedingDate() {
        return lastFeedingDate;
    }

    public Date getLastMoltingDate() {
        return lastMoltingDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public void setLastFeedingDate(Date lastFeedingDate) {
        this.lastFeedingDate = lastFeedingDate;
    }

    public void setLastMoltingDate(Date lastMoltingDate) {
        this.lastMoltingDate = lastMoltingDate;
    }
}
