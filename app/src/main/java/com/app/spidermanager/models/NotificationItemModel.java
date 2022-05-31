package com.app.spidermanager.models;

public class NotificationItemModel {
    private final int id, period;
    private final String name, type;

    public NotificationItemModel(int id, int period,
                                 String name, String type) {
        this.id = id;
        this.period = period;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
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
