package com.app.spidermanager.models;

/**
 * Модель для представления оповещения
 * в списке
 */
public class NotificationItemModel extends ModelWithId{
    // Период оповещения, id паука
    private final int period;
    // Состояние оповещения
    private final boolean notificationNeeded;
    // Кличка паука, вид паука
    private final String name, type;

    public NotificationItemModel(int id, int period,
                                 String name, String type,
                                 boolean notificationNeeded) {
        super(id);
        this.period = period;
        this.name = name;
        this.type = type;
        this.notificationNeeded = notificationNeeded;
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

    public boolean isNotificationNeeded() {
        return notificationNeeded;
    }
}
