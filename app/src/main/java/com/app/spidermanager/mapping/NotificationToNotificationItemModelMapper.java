package com.app.spidermanager.mapping;

import com.app.db.entities.Notification;
import com.app.spidermanager.models.NotificationItemModel;
import com.app.spidermanager.models.UpdNotificationModel;

/**
 * @see Notification
 * @see NotificationItemModel
 */
public class NotificationToNotificationItemModelMapper
        implements IMapper<Notification, NotificationItemModel> {
    @Override
    public NotificationItemModel map(Notification notification) {
        return new NotificationItemModel(
                notification.getId(),
                notification.getSpider().getId(),
                Integer.toString(notification.getPeriod()),
                notification.getSpider().getName(),
                notification.getSpider().getType(),
                notification.getNotificationNeeded()
        );
    }
}
