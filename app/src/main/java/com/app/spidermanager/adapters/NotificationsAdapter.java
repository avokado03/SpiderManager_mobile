package com.app.spidermanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.spidermanager.R;
import com.app.spidermanager.models.NotificationItemModel;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder>{

    private final LayoutInflater inflater;
    private final List<NotificationItemModel> notifications;

    public NotificationsAdapter(Context context,
                                List<NotificationItemModel> notifications) {
        this.inflater = LayoutInflater.from(context);
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public NotificationsAdapter.NotificationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notification_item, parent, false);
        return new NotificationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsAdapter.NotificationsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static class NotificationsViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, typeView;
        final EditText periodEdit;

        public NotificationsViewHolder(@NonNull View view) {
            super(view);
            nameView = view.findViewById(R.id.notify_spider_name);
            typeView = view.findViewById(R.id.notify_spider_type);
            periodEdit = view.findViewById(R.id.notify_period_edit);
        }
    }
}
