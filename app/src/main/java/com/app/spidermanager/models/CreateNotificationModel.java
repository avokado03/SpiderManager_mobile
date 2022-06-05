package com.app.spidermanager.models;

/**
 * Модель для создания оповещения
 */
public class CreateNotificationModel{
    // Период оповещения, id паука
    private final int period, spiderId;
    // Состояние оповещения
    private final boolean notificationNeeded;

    public CreateNotificationModel(int period, int spiderId, boolean notificationNeeded) {
        this.period = period;
        this.spiderId = spiderId;
        this.notificationNeeded = notificationNeeded;
    }

    public int getPeriod() {
        return period;
    }

    public boolean isNotificationNeeded() {
        return notificationNeeded;
    }

    public int getSpiderId() {
        return spiderId;
    }
}