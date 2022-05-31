package com.app.spidermanager.models;

/**
 * Базовый класс моделей с Id
 */
public abstract class ModelWithId {
    // Идентификатор
    protected final int id;

    public ModelWithId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
