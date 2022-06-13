package com.app.notifications;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.app.db.entities.Notification;
import com.app.db.entities.Spider;
import com.app.spidermanager.R;
import com.app.spidermanager.repositories.NotificationsRepository;
import com.app.spidermanager.repositories.SpidersRepository;
import com.app.spidermanager.utils.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Сервис оповещения
 */
public class NotificationService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationsRepository notificationsRepository = new NotificationsRepository(context);
        SpidersRepository spidersRepository = new SpidersRepository(context);
        List<Notification> notifications = notificationsRepository.all();
        Date currentDate = new Date();

        notifications.forEach(notification -> {
            Spider spider = notification.getSpider();
            if (notification.getNotificationNeeded()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(spider.getLastFeedingDate());
                calendar.add(Calendar.DATE, notification.getPeriod());
                Date needFeedingDate = calendar.getTime();

               if (Utils.dateWithoutTime(currentDate).getTime() >= needFeedingDate.getTime()) {
                    notify(context, spider);
                   spider.setLastFeedingDate(new Date());
                   spidersRepository.update(spider);
                }
            }
        });
    }

    /**
     * Создание и вывод оповещения
     */
    public void notify(Context context, Spider spider){
        String channel_id = "1";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channel_id)
                .setSmallIcon(R.mipmap.notification_icon_foreground)
                .setContentTitle("Пора кормить паука")
                .setContentText(String.format("Не забудьте покормить %s", spider.getName()));

        NotificationManager notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= 26){
            String title = "spiders_notification";
            NotificationChannel channel = new NotificationChannel(channel_id, title, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channel_id);
        }

        android.app.Notification not = builder.build();
        notificationManager.notify(spider.getId(), not);
    }


    /**
     * Возвращает намерение, отложенное во времени
     */
    @SuppressLint("UnspecifiedImmutableFlag")
    public static PendingIntent getPendingIntent(Context context) {
        Intent action = new Intent(context, NotificationService.class);
        return PendingIntent.getBroadcast(context, 1, action, 0);
    }
}
