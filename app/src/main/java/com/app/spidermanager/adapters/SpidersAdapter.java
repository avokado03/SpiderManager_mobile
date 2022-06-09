package com.app.spidermanager.adapters;

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

import java.util.List;

public class SpidersAdapter extends RecyclerView.Adapter<SpidersAdapter.SpiderViewHolder>{

    public interface OnSpiderClickListener {
        void OnClick(SpiderItemModel model, int position);
    }

    private final OnSpiderClickListener onClickListener;

    private final LayoutInflater inflater;
    private final SpiderListModel<SpiderItemModel> spiders;

    public SpidersAdapter(Context context,
                          OnSpiderClickListener onClickListener, SpiderListModel<SpiderItemModel> spiders) {
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
        //SpiderItemModel current = spiders.get(position);
/*        holder.photoView.setImageBitmap(Utils.getBitmapFromArray(
                current.getPhoto(),
                holder.photoView.getWidth(),
                holder.photoView.getHeight())
        );*/
        /*holder.sexView.setImageResource(current.getSex() ?
                R.mipmap.female_icon : R.mipmap.male_icon);*/
        SpiderItemBinding binding = holder.getBinding();
        binding.setSpider(spiders.getItems().get(position));
        binding.executePendingBindings();
//        holder.feedingDateView.setText(current.getFeedingDate());
//        holder.typeView.setText(current.getType());
//        holder.nameView.setText(current.getName());
//        holder.itemView.setOnClickListener(view -> onClickListener.OnClick(current, position));
    }

    @Override
    public int getItemCount() {
        return spiders.getItems().size();
    }

    public static class SpiderViewHolder extends ViewHolder {
        private final SpiderItemBinding binding;

        public SpiderViewHolder(View view){
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public SpiderItemBinding getBinding(){
            return binding;
        }

        /*final ImageView photoView, sexView;
        final TextView nameView, typeView, feedingDateView;
        SpiderViewHolder(@NonNull View view){
            super(view);
            photoView = view.findViewById(R.id.photo);
            nameView = view.findViewById(R.id.name);
            sexView = view.findViewById(R.id.sex);
            typeView = view.findViewById(R.id.type);
            feedingDateView = view.findViewById(R.id.feeding_date);
        }*/
    }
}
