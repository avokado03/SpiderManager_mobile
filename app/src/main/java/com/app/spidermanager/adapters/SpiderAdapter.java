package com.app.spidermanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.app.spidermanager.R;
import com.app.spidermanager.models.SpiderItemModel;
import com.app.spidermanager.utils.Utils;

import java.util.List;

public class SpiderAdapter extends RecyclerView.Adapter<SpiderAdapter.SpiderViewHolder>{

    private final OnSpiderClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<SpiderItemModel> spiders;

    public SpiderAdapter(Context context,
                         OnSpiderClickListener onClickListener,  List<SpiderItemModel> spiders) {
        this.onClickListener = onClickListener;
        this.spiders = spiders;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public SpiderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.spider_item, parent, false);
        return new SpiderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpiderViewHolder holder, int position) {
        SpiderItemModel current = spiders.get(position);
        holder.photoView.setImageBitmap(Utils.getBitmapFromArray(
                current.getPhoto(),
                holder.photoView.getWidth(),
                holder.photoView.getHeight())
        );
        holder.sexView.setImageDrawable(current.getSex());
        holder.feedingDateView.setText(current.getFeedingDate());
        holder.typeView.setText(current.getType());
        holder.nameView.setText(current.getName());
        holder.itemView.setOnClickListener(view -> onClickListener.OnClick(current, position));
    }

    @Override
    public int getItemCount() {
        return spiders.size();
    }

    public static class SpiderViewHolder extends ViewHolder {
        final ImageView photoView, sexView;
        final TextView nameView, typeView, feedingDateView;
        SpiderViewHolder(View view){
            super(view);
            photoView = view.findViewById(R.id.photo);
            nameView = view.findViewById(R.id.name);
            sexView = view.findViewById(R.id.sex);
            typeView = view.findViewById(R.id.type);
            feedingDateView = view.findViewById(R.id.feeding_date);
        }
    }
}
