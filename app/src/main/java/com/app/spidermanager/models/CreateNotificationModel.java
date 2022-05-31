package com.app.spidermanager.models;

/**
 * Модель для создания оповещения
 */
public class CreateNotificationModel{
    // Период оповещения
    private final int period;
    // Состояние оповещения
    private final boolean notificationNeeded;

    public CreateNotificationModel(int period, boolean notificationNeeded) {
        this.period = period;
        this.notificationNeeded = notificationNeeded;
    }

    public int getPeriod() {
        return period;
    }

    public boolean isNotificationNeeded() {
        return notificationNeeded;
    }
}