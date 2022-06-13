package com.app.spidermanager.models;

/**
 * Модель для представления оповещения
 * в списке
 */
public class NotificationItemModel extends ModelWithId{
    // Id паука
    private int spiderId;
    // Состояние оповещения
    private boolean notificationNeeded;
    // Кличка паука, вид паука
    // Период оповещения
    private String name, type, period;

    public NotificationItemModel(int id, int spiderId, String period,
                                 String name, String type,
                                 boolean notificationNeeded) {
        super(id);
        this.period = period;
        this.name = name;
        this.type = type;
        this.spiderId = spiderId;
        this.notificationNeeded = notificationNeeded;
    }

    public boolean isNotificationNeeded() {
        return notificationNeeded;
    }

    public void setNotificationNeeded(boolean notificationNeeded) {
        this.notificationNeeded = notificationNeeded;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(int spiderId) {
        this.spiderId = spiderId;
    }
}
