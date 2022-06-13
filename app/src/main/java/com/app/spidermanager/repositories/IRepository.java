package com.app.spidermanager.repositories;

import com.app.db.entities.BaseEntity;

import java.util.List;

/**
 * Контракт для репозипотиев сущностей БД
 * @param <T> тип сущности
 */
public interface IRepository<T extends BaseEntity>{
    /**
     * Найти все сущности
     */
    List<T> all();

    /**
     * Поиск по id
     * @param id идентификатор
     */
    T get(int id);

    /**
     * Создание новой сущности
     * @return Идентификатор новой сущности
     */
    int create(T item);

    /**
     * Обновление сущности
     */
    T update(T item);

    /**
     * Обновление списка сущностей
     */
    void update(List<T> items);

    /**
     * Удаление сущности
     * @param id идентификатор сущности
     */
    void delete(int id);
}
