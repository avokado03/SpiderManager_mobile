package com.app.spidermanager.mapping;

import com.app.db.entities.Spider;
import com.app.spidermanager.models.SpiderItemModel;
import com.app.spidermanager.models.UpdSpiderModel;
import com.app.spidermanager.utils.Utils;

/**
 * @see Spider
 * @see UpdSpiderModel
 */
public class SpiderToUpdSpiderModelMapper implements IMapper<Spider, UpdSpiderModel>{
    @Override
    public UpdSpiderModel map(Spider spider) {
        return new UpdSpiderModel(
                spider.getId(),
                Integer.toString(spider.getAge()),
                spider.getName(),
                spider.getType(),
                Utils.getDrawableFromArray(spider.getPhoto()),
                spider.getSex(),
                spider.getLastFeedingDate(),
                spider.getLastMoltingDate()
        );
    }
}
