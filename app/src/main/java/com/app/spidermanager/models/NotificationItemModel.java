package com.app.spidermanager.models;

/**
 * Модель для представления оповещения
 * в списке
 */
public class NotificationItemModel extends ModelWithId{
    // Период оповещения
    private final int period;
    // Кличка паука, вид паука
    private final String name, type;

    public NotificationItemModel(int id, int period,
                                 String name, String type) {
        super(id);
        this.period = period;
        this.name = name;
        this.type = type;
    }

    public int getPeriod() {
        return period;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
