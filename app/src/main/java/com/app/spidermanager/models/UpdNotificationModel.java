package com.app.spidermanager.models;

/**
 * Модель для обновления настроек оповещения
 */
public class UpdNotificationModel extends ModelWithId{
    // Период оповещения
    private int period;
    // Состояние оповещения
    private Boolean notificationNeeded;

    public UpdNotificationModel(int id, int period, Boolean notificationNeeded) {
        super(id);
        this.period = period;
        this.notificationNeeded = notificationNeeded;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Boolean getNotificationNeeded() {
        return notificationNeeded;
    }

    public void setNotificationNeeded(Boolean notificationNeeded) {
        this.notificationNeeded = notificationNeeded;
    }
}
