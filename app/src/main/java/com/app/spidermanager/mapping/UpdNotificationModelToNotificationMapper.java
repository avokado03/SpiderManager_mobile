package com.app.spidermanager.mapping;

import com.app.db.entities.Notification;
import com.app.spidermanager.models.UpdNotificationModel;

public class UpdNotificationModelToNotificationMapper implements IMapper<UpdNotificationModel, Notification> {
    @Override
    public Notification map(UpdNotificationModel updNotificationModel) {
        return new Notification(
                updNotificationModel.getId(),
                updNotificationModel.getPeriod(),
                updNotificationModel.getNotificationNeeded()
        );
    }
}
