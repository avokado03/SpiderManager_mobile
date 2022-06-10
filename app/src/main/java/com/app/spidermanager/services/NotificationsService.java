package com.app.spidermanager.services;

import android.content.Context;

import com.app.db.entities.Notification;
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
import java.util.List;
import java.util.stream.Collectors;

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

    public void update(List<UpdNotificationModel> notifications) {
        notificationsRepository.
                update(notifications.stream().map(notification ->
                                new UpdNotificationModelToNotificationMapper().map(notification)).
                        collect(Collectors.toList()));
    }

    public void delete(int id) {
        notificationsRepository.delete(id);
    }
}
