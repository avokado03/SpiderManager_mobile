package com.app.spidermanager.mapping;

import com.app.db.entities.Notification;
import com.app.spidermanager.models.NotificationItemModel;

public class NotificationToNotificationItemModelMapper
        implements IMapper<Notification, NotificationItemModel> {
    @Override
    public NotificationItemModel map(Notification notification) {
        return new NotificationItemModel(
                notification.getId(),
                notification.getPeriod(),
                notification.getSpider().getName(),
                notification.getSpider().getType(),
                notification.getNotificationNeeded()
        );
    }
}
