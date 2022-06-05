package com.app.spidermanager.mapping;

import com.app.db.entities.Notification;
import com.app.spidermanager.models.CreateNotificationModel;

public class CreateNotificationModelToNotificationMapper
        implements IMapper<CreateNotificationModel, Notification> {
    @Override
    public Notification map(CreateNotificationModel createNotificationModel) {
        return new Notification(
                createNotificationModel.getSpiderId(),
                createNotificationModel.isNotificationNeeded(),
                createNotificationModel.getPeriod()
        );
    }
}
