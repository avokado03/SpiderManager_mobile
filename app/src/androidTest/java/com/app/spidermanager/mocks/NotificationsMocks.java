package com.app.spidermanager.mocks;

import com.app.models.Notification;

import java.util.ArrayList;

public class NotificationsMocks {
    private final ArrayList<Notification> notifications;

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public NotificationsMocks() {
        notifications = new ArrayList<>();

        notifications.add(new Notification(1, 1, 21));
        notifications.add(new Notification(2, 2, 14));
        notifications.add(new Notification(3, 3, 7));
        notifications.add(new Notification(4, 4, 28));
        notifications.add(new Notification(5, 5, 31));
    }
}
