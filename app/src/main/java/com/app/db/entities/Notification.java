package com.app.db.entities;

/**
 * Сущность "Оповещение"
 */
public class Notification extends BaseEntity {
    // Id паука
    private int spiderId;
    // Период оповещения
    private int period;
    // Состояние
    private boolean notificationNeeded;
    // Паук
    private Spider spider;

    public Notification(int id, int spiderId, int period, boolean notificationNeeded) {
        super(id);
        this.spiderId = spiderId;
        this.period = period;
        this.notificationNeeded = notificationNeeded;
    }

    public Notification(int id, int period, boolean notificationNeeded) {
        super(id);
        this.period = period;
        this.notificationNeeded = notificationNeeded;
    }

    public Notification(int period, boolean notificationNeeded, int spiderId) {
        super(null);
        this.period = period;
        this.spiderId = spiderId;
        this.notificationNeeded = notificationNeeded;
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

    public Spider getSpider() {
        return spider;
    }

    public void setSpider(Spider spider) {
        this.spider = spider;
    }

    public boolean getNotificationNeeded() {
        return notificationNeeded;
    }

    public void setNotificationNeeded(boolean notificationNeeded) {
        this.notificationNeeded = notificationNeeded;
    }
}
