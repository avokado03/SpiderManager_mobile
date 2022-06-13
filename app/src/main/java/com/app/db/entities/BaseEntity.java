package com.app.db.entities;

/**
 * Базовый класс сущностей
 */
public abstract class BaseEntity {
    //Идентификатор
    private final Integer Id;

    public BaseEntity () {Id = null;}

    public BaseEntity(Integer id) {
        Id = id;
    }

    public Integer getId() {
        return Id;
    }
}
