package com.app.spidermanager.models;

import java.util.Date;

/**
 * Модель для обновления записи
 * о пауке
 */
public class UpdSpiderModel extends ModelWithId{
    // Возраст
    private Integer age;
    // Кличка, вид
    private String name, type;
    // Фото
    private byte[] photo;
    // Пол
    private Boolean sex;
    // Дата последнего кормления, дата последней линьки
    private Date lastFeedingDate, lastMoltingDate;


    public UpdSpiderModel(int id, Integer age, String name, String type,
                          byte[] photo, Boolean sex,
                          Date lastFeedingDate, Date lastMoltingDate) {
        super(id);
        this.age = age;
        this.name = name;
        this.type = type;
        this.photo = photo;
        this.sex = sex;
        this.lastFeedingDate = lastFeedingDate;
        this.lastMoltingDate = lastMoltingDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Date getLastFeedingDate() {
        return lastFeedingDate;
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
