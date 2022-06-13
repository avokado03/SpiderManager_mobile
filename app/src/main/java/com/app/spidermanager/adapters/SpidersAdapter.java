package com.app.spidermanager.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.app.spidermanager.R;
import com.app.spidermanager.databinding.SpiderItemBinding;
import com.app.spidermanager.models.SpiderItemModel;
import com.app.spidermanager.models.SpiderListModel;
import com.app.spidermanager.services.SpidersService;
import com.app.spidermanager.utils.DialogUtils;

import java.util.List;

/**
 * Адаптер для отображения списка пауков
 */
public class SpidersAdapter extends RecyclerView.Adapter<SpidersAdapter.SpiderViewHolder>{

    /**
     * Интерфейс события клика по элементу списка
     */
    public interface OnSpiderClickListener {
        void OnClick(SpiderItemModel model, int position);
    }

    private final OnSpiderClickListener onClickListener;

    private final LayoutInflater inflater;
    private final SpiderListModel<SpiderItemModel> spiders;
    private final SpidersService service;

    public SpidersAdapter(Context context,
                          OnSpiderClickListener onClickListener,
                          SpiderListModel<SpiderItemModel> spiders,
                          SpidersService service) {
        this.onClickListener = onClickListener;
        this.spiders = spiders;
        this.inflater = LayoutInflater.from(context);
        this.service = service;
    }

    @NonNull
    @Override
    public SpiderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.spider_item, parent, false);
        return new SpiderViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull SpiderViewHolder holder, int position) {
        SpiderItemModel current = spiders.getItems().get(position);
        SpiderItemBinding binding = holder.getBinding();
        binding.setSpider(current);
        binding.executePendingBindings();
        holder.itemView.setOnClickListener(view -> onClickListener.OnClick(current, position));
        holder.getBinding().buttonSpiderDelete.setOnClickListener(v ->
            DialogUtils.createConfirmDialog(inflater.getContext(), (x, y) -> {
            service.delete(current.getId());
            spiders.getItems().remove(current);
            SpidersAdapter.this.notifyDataSetChanged();
        }).show());
    }

    @Override
    public int getItemCount() {
        return spiders.getItems().size();
    }

    /**
     * Описывает содержимое списка и хранит привязки
     */
    public static class SpiderViewHolder extends ViewHolder {
        private final SpiderItemBinding binding;

        public SpiderViewHolder(View view){
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public SpiderItemBinding getBinding(){
            return binding;
        }
    }
}
