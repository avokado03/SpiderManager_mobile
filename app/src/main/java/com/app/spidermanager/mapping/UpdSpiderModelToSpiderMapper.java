package com.app.spidermanager.mapping;

import com.app.db.entities.Spider;
import com.app.spidermanager.models.UpdSpiderModel;

public class UpdSpiderModelToSpiderMapper implements IMapper<UpdSpiderModel, Spider> {
    @Override
    public Spider map(UpdSpiderModel updSpiderModel) {
        return new Spider(
                updSpiderModel.getId(),
                updSpiderModel.getName(),
                updSpiderModel.getAge(),
                updSpiderModel.getType(),
                updSpiderModel.getPhoto(),
                updSpiderModel.getSex(),
                updSpiderModel.getLastFeedingDate(),
                updSpiderModel.getLastMoltingDate()
        );
    }
}
