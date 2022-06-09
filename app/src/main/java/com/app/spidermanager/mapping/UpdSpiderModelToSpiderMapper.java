package com.app.spidermanager.mapping;

import com.app.db.entities.Spider;
import com.app.spidermanager.models.UpdSpiderModel;
import com.app.spidermanager.utils.Utils;

public class UpdSpiderModelToSpiderMapper implements IMapper<UpdSpiderModel, Spider> {
    @Override
    public Spider map(UpdSpiderModel updSpiderModel) {
        return new Spider(
                updSpiderModel.getId(),
                updSpiderModel.getName(),
                Integer.parseInt(updSpiderModel.getAge()),
                updSpiderModel.getType(),
                Utils.getByteArrayFromDrawable(updSpiderModel.getPhoto()),
                updSpiderModel.getSex(),
                Utils.stringToDate(updSpiderModel.getLastFeedingDate()),
                Utils.stringToDate(updSpiderModel.getLastMoltingDate())
        );
    }
}
