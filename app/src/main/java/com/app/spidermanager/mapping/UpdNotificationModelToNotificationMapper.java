package com.app.spidermanager.mapping;

import com.app.db.entities.Notification;
import com.app.db.entities.Spider;
import com.app.spidermanager.models.UpdNotificationModel;
import com.app.spidermanager.models.UpdSpiderModel;

/**
 * @see UpdNotificationModel
 * @see Notification
 */
public class UpdNotificationModelToNotificationMapper
        implements IMapper<UpdNotificationModel, Notification> {
    @Override
    public Notification map(UpdNotificationModel updNotificationModel) {
        return new Notification(
                updNotificationModel.getId(),
                updNotificationModel.getSpiderId(),
                updNotificationModel.getPeriod(),
                updNotificationModel.getNotificationNeeded()
        );
    }
}
