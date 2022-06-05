package com.app.spidermanager.repositories;

import com.app.db.entities.BaseEntity;

import java.util.List;

/**
 *
 * @param <T>
 */
public interface IRepository<T extends BaseEntity>{
    List<T> all();
    T get(int id);
    int create(T item);
    T update(T item);
    void delete(int id);
}
