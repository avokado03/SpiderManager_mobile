package com.app.spidermanager.mapping;

import android.annotation.SuppressLint;
import android.util.Log;

import com.app.db.entities.Spider;
import com.app.spidermanager.models.CreateSpiderModel;
import com.app.spidermanager.models.SpiderItemModel;
import com.app.spidermanager.utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @see CreateSpiderModel
 * @see Spider
 */
public class CreateSpiderModelToSpiderMapper implements IMapper<CreateSpiderModel, Spider> {
    @Override
    public Spider map(CreateSpiderModel spiderItemModel) {
        return new Spider(
                null,
                spiderItemModel.getName(),
                Integer.parseInt(spiderItemModel.getAge()),
                spiderItemModel.getType(),
                Utils.getByteArrayFromDrawable(spiderItemModel.getPhoto()),
                spiderItemModel.getSex(),
                Utils.stringToDate(spiderItemModel.getLastFeedingDate()),
                Utils.stringToDate(spiderItemModel.getLastMoltingDate())
        );
    }
}
