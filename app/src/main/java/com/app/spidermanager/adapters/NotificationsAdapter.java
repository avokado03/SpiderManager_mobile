package com.app.spidermanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.spidermanager.R;
import com.app.spidermanager.databinding.NotificationItemBinding;
import com.app.spidermanager.databinding.SpiderItemBinding;
import com.app.spidermanager.models.NotificationItemModel;
import com.app.spidermanager.models.NotificationListModel;
import com.app.spidermanager.services.NotificationsService;
import com.app.spidermanager.validation.NotZeroValidator;

import java.util.List;

/**
 * Адаптер для отображения списка оповещений
 */
public class NotificationsAdapter
        extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder>{

    private final LayoutInflater inflater;
    private final NotificationListModel notifications;

    public NotificationsAdapter(Context context,
                                NotificationListModel notifications) {
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
        NotificationItemBinding binding = holder.getBinding();
        binding.setNotification(notifications.getItems().get(position));
        binding.executePendingBindings();
        EditText periodView = holder.getBinding().notifyPeriodEdit;
        periodView.addTextChangedListener(new NotZeroValidator(periodView));

    }

    @Override
    public int getItemCount() {
        return notifications.getItems().size();
    }

    /**
     * Описывает содержимое списка и хранит привязки
     */
    public static class NotificationsViewHolder extends RecyclerView.ViewHolder {
        private final NotificationItemBinding binding;

        public NotificationsViewHolder(View view){
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public NotificationItemBinding getBinding(){
            return binding;
        }
    }

}
