package com.app.spidermanager.models;

/**
 * Модель для представления записи
 * о пауке в списке
 */
public class SpiderItemModel extends ModelWithId{
    // Кличка, вид, дата последнего кормления, дата последней линьки
    private final String name, type, feedingDate, moltingDate;
    // Фото
    private final byte[] photo;
    // Пол
    private final boolean sex;
    // Возраст
    private final int age;

    public SpiderItemModel(int id, String name, int age, String type,
                           String feedingDate,
                           String moltingDate,
                           byte[] photo, boolean sex) {
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

    public String getType() {
        return type;
    }

    public String getFeedingDate() {
        return feedingDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public boolean getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getMoltingDate() {
        return moltingDate;
    }
}
