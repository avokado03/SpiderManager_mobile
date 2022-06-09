package com.app.spidermanager.repositories;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.app.db.entities.Spider;
import com.app.spidermanager.mapping.MappingHelpers;

import java.util.Date;
import java.util.List;

public class SpidersRepository extends RepositoryBase<Spider> {
    public SpidersRepository(Context context) {
        super(context);
        tableName = "Spiders";
        primaryField = "SpidersId";
    }

    @SuppressLint("Range")
    @Override
    protected Spider cursorToEntity(Cursor cursor) {
        return new Spider(
                cursor.getInt(cursor.getColumnIndex(primaryField)),
                cursor.getString(cursor.getColumnIndex("Name")),
                cursor.getInt(cursor.getColumnIndex("Age")),
                cursor.getString(cursor.getColumnIndex("Type")),
                cursor.getBlob(cursor.getColumnIndex("Photo")),
                cursor.getInt(cursor.getColumnIndex("Sex")),
                new Date(cursor.getLong(cursor.getColumnIndex("LastFeedingDate"))),
                new Date(cursor.getLong(cursor.getColumnIndex("LastMoltingDate")))
        );
    }

    @Override
    protected ContentValues entityToContentValues(Spider entity) {
        ContentValues values = new ContentValues();
        values.put(primaryField, entity.getId());
        values.put("Name", entity.getName());
        values.put("Age", entity.getAge());
        values.put("Type", entity.getType());
        values.put("Photo", entity.getPhoto());
        values.put("Sex", entity.getSex());
        values.put("LastFeedingDate", entity.getLastFeedingDate().getTime());
        values.put("LastMoltingDate", entity.getLastMoltingDate().getTime());
        return values;
    }

    @Override
    public List<Spider> all() {
        return super.all();
    }

    @Override
    public Spider get(int id) {
        return super.get(id);
    }

    @Override
    public int create(Spider item) {
        return super.create(item);
    }

    @Override
    public Spider update(Spider item) {
        return super.update(item);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }
}
