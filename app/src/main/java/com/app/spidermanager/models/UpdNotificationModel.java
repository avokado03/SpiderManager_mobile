package com.app.spidermanager.models;

/**
 * Модель для обновления настроек оповещения
 */
public class UpdNotificationModel extends ModelWithId{
    // Период оповещения, id паука
    private int period, spiderId;
    // Состояние оповещения
    private Boolean notificationNeeded;

    public UpdNotificationModel(int id, int spiderId, int period, Boolean notificationNeeded) {
        super(id);
        this.period = period;
        this.spiderId = spiderId;
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

    public int getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(int spiderId) {
        this.spiderId = spiderId;
    }
}
