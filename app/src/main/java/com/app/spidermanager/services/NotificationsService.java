package com.app.spidermanager.services;

import android.content.Context;

import com.app.spidermanager.mapping.CreateNotificationModelToNotificationMapper;
import com.app.spidermanager.mapping.NotificationToNotificationItemModelMapper;
import com.app.spidermanager.mapping.NotificationToUpdNotificationModelMapper;
import com.app.spidermanager.mapping.UpdNotificationModelToNotificationMapper;
import com.app.spidermanager.models.CreateNotificationModel;
import com.app.spidermanager.models.NotificationItemModel;
import com.app.spidermanager.models.UpdNotificationModel;
import com.app.spidermanager.repositories.NotificationsRepository;
import com.app.spidermanager.repositories.SpidersRepository;

import java.util.ArrayList;

public class NotificationsService {
    protected NotificationsRepository notificationsRepository;
    protected SpidersRepository spidersRepository;

    public NotificationsService(Context context) {
        notificationsRepository = new NotificationsRepository(context);
        spidersRepository = new SpidersRepository(context);
    }

    public ArrayList<NotificationItemModel> getAll() {
        ArrayList<NotificationItemModel> items = new ArrayList<>();
        notificationsRepository.all().forEach(notification
                -> items.add(new NotificationToNotificationItemModelMapper().map(notification)));
        return items;
    }

    public UpdNotificationModel getById(int id){
        return new NotificationToUpdNotificationModelMapper().map(notificationsRepository.get(id));
    }

    public CreateNotificationModel create(CreateNotificationModel createNotificationModel) {
        notificationsRepository.create(new CreateNotificationModelToNotificationMapper().
                map(createNotificationModel));
        return createNotificationModel;
    }

    public UpdNotificationModel update(UpdNotificationModel updNotificationModel) {
        notificationsRepository.update(new UpdNotificationModelToNotificationMapper().
                map(updNotificationModel));
        return updNotificationModel;
    }

    public void delete(int id) {
        notificationsRepository.delete(id);
    }
}
