package com.app.spidermanager.mapping;

import com.app.db.entities.Notification;
import com.app.spidermanager.models.UpdNotificationModel;

public class NotificationToUpdNotificationModelMapper implements IMapper<Notification, UpdNotificationModel> {
    @Override
    public UpdNotificationModel map(Notification notification) {
        return new UpdNotificationModel(
                notification.getId(),
                notification.getPeriod(),
                notification.getNotificationNeeded()
        );
    }
}
