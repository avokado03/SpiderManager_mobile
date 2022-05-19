package com.app.models;

/**
 * Модель "Оповещение"
 */
public class Notification {
    // Id
    private final int notificationId;
    // Id паука
    private int spiderId;
    // Период оповещения
    private int period;

    public Notification(int notificationId, int spiderId, int period) {
        this.notificationId = notificationId;
        this.spiderId = spiderId;
        this.period = period;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public int getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(int spiderId) {
        this.spiderId = spiderId;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
