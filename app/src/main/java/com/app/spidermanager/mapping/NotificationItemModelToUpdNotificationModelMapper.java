package com.app.spidermanager.mapping;

import com.app.spidermanager.models.NotificationItemModel;
import com.app.spidermanager.models.UpdNotificationModel;

/**
 * @see NotificationItemModel
 * @see UpdNotificationModel
 */
public class NotificationItemModelToUpdNotificationModelMapper
        implements IMapper <NotificationItemModel, UpdNotificationModel> {
    @Override
    public UpdNotificationModel map(NotificationItemModel input) {
        return new UpdNotificationModel(
                input.getId(),
                input.getSpiderId(),
                Integer.parseInt(input.getPeriod()),
                input.isNotificationNeeded()
        );
    }
}
