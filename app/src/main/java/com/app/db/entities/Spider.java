package com.app.db.entities;

import java.util.Date;

/**
 * Сущность "Паук"
 */
public class Spider extends BaseEntity{
    //Кличка
    private String name;
    //Возраст (в линьках)
    private int age;
    // Биологический вид
    private String type;

    // Фото
    private byte[] photo;
    //Пол
    private int sex;
    // Дата последней кормежки
    private Date lastFeedingDate;
    // Дата последней линьки
    private Date lastMoltingDate;
    // Оповещение
    private Notification notification;

    public Spider(){
        super(null);
    }

    public Spider(Integer id, String name, int age, String type,
                  byte[] photo, int sex, Date lastFeedingDate,
                  Date lastMoltingDate) {
        super(id);
        this.name = name;
        this.age = age;
        this.type = type;
        this.photo = photo;
        this.sex = sex;
        this.lastFeedingDate = lastFeedingDate;
        this.lastMoltingDate = lastMoltingDate;
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

    public int getSex() {
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

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setLastFeedingDate(Date lastFeedingDate) {
        this.lastFeedingDate = lastFeedingDate;
    }

    public void setLastMoltingDate(Date lastMoltingDate) {
        this.lastMoltingDate = lastMoltingDate;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
