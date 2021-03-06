package com.app.spidermanager.repositories;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.app.db.entities.Notification;

import java.util.List;

/**
 * Репозиторий для сущности оповещения
 * @see Notification
 */
public class NotificationsRepository extends RepositoryBase<Notification> {
    final private SpidersRepository spidersRepository;

    public NotificationsRepository(Context context) {
        super(context);
        tableName = "Notifications";
        primaryField = "NotificationsId";
        spidersRepository = new SpidersRepository(context);
    }

    @SuppressLint("Range")
    protected Notification cursorToEntity(Cursor cursor){
        Notification notification = new Notification(
                cursor.getInt(cursor.getColumnIndex(primaryField)),
                cursor.getInt(cursor.getColumnIndex("SpiderId")),
                cursor.getInt(cursor.getColumnIndex("Period")),
                cursor.getInt(cursor.getColumnIndex("NotificationNeeded")) == 1
        );
        notification.setSpider(spidersRepository.get(notification.getSpiderId()));

        return notification;
    }

    @Override
    protected ContentValues entityToContentValues(Notification entity) {
        ContentValues values = new ContentValues();
        values.put("SpiderId", entity.getSpiderId());
        values.put("Period", entity.getPeriod());
        values.put("NotificationNeeded", entity.getNotificationNeeded());
        return values;
    }

    @Override
    public List<Notification> all() {
        return super.all();
    }

    @Override
    public Notification get(int id) {
        return super.get(id);
    }

    @Override
    public int create(Notification item) {
        return super.create(item);
    }

    @Override
    public void update(List<Notification> items) {
        super.update(items);
    }

    @Override
    public Notification update(Notification item) {
        return super.update(item);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void delete(String whereClause, String[] whereArgs) {
        super.delete(whereClause, whereArgs);
    }
}
