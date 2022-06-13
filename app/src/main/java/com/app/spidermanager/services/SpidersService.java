package com.app.spidermanager.services;

import android.content.Context;

import com.app.db.entities.Notification;
import com.app.spidermanager.mapping.CreateSpiderModelToSpiderMapper;
import com.app.spidermanager.mapping.SpiderToSpiderItemModelMapper;
import com.app.spidermanager.mapping.SpiderToUpdSpiderModelMapper;
import com.app.spidermanager.mapping.UpdSpiderModelToSpiderMapper;
import com.app.spidermanager.models.CreateSpiderModel;
import com.app.spidermanager.models.SpiderItemModel;
import com.app.spidermanager.models.UpdSpiderModel;
import com.app.spidermanager.repositories.NotificationsRepository;
import com.app.spidermanager.repositories.SpidersRepository;

import java.util.ArrayList;

/**
 * Сервис для работы с карточками пауков
 */
public class SpidersService {
    protected SpidersRepository spidersRepository;
    protected NotificationsRepository notificationsRepository;

    public SpidersService(Context context) {
        spidersRepository = new SpidersRepository(context);
        notificationsRepository = new NotificationsRepository(context);
    }

    /**
     * Найти все записи
     */
    public ArrayList<SpiderItemModel> getAll(){
        ArrayList<SpiderItemModel> items = new ArrayList<>();
        spidersRepository.all().forEach(spider ->
                items.add(new SpiderToSpiderItemModelMapper().map(spider)));
        return items;
    }

    /**
     * Найти запись по id
     */
    public UpdSpiderModel getById(int id){
        return new SpiderToUpdSpiderModelMapper().map(spidersRepository.get(id));
    }

    /**
     * Создать карточку паука со связанным оповещением
     */
    public int create(CreateSpiderModel createSpiderModel){
        int newSpiderId = spidersRepository.create(new CreateSpiderModelToSpiderMapper().
                map(createSpiderModel));
        int notificationId = notificationsRepository.create(
                new Notification(null, newSpiderId, 1, false));
        return newSpiderId;
    }

    /**
     * Обновить карточку паука
     */
    public UpdSpiderModel update(UpdSpiderModel updSpiderModel){
        spidersRepository.update(new UpdSpiderModelToSpiderMapper().map(updSpiderModel));
        return updSpiderModel;
    }

    /**
     * Удалить паука со связанным оповещением
     */
    public void delete(int id){
        spidersRepository.delete(id);
        notificationsRepository.delete("SpiderId = ?",
                new String[]{Integer.toString(id)});
    }
}


