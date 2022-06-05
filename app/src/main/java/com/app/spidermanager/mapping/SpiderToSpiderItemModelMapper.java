package com.app.spidermanager.mapping;

import android.annotation.SuppressLint;

import com.app.db.entities.Spider;
import com.app.spidermanager.models.SpiderItemModel;

import java.text.SimpleDateFormat;

public class SpiderToSpiderItemModelMapper implements IMapper<Spider, SpiderItemModel> {
    @Override
    public SpiderItemModel map(Spider spider) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return new SpiderItemModel(
                spider.getId(),
                spider.getName(),
                spider.getAge(),
                spider.getType(),
                format.format(spider.getLastFeedingDate()),
                format.format(spider.getLastMoltingDate()),
                spider.getPhoto(),
                spider.getSex()
        );
    }
}
