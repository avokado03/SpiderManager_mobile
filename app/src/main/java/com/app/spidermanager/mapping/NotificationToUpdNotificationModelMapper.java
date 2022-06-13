package com.app.spidermanager.mapping;

import com.app.db.entities.Notification;
import com.app.spidermanager.models.NotificationItemModel;
import com.app.spidermanager.models.UpdNotificationModel;

/**
 * @see Notification
 * @see UpdNotificationModel
 */
public class NotificationToUpdNotificationModelMapper implements IMapper<Notification, UpdNotificationModel> {
    @Override
    public UpdNotificationModel map(Notification notification) {
        return new UpdNotificationModel(
                notification.getId(),
                notification.getSpider().getId(),
                notification.getPeriod(),
                notification.getNotificationNeeded()
        );
    }
}
