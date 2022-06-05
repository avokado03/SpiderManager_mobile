package com.app.spidermanager.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.db.DbHelper;
import com.app.db.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryBase<T extends BaseEntity> implements IRepository<T> {
    protected SQLiteDatabase db;
    protected String tableName;
    protected String primaryField = "id";

    protected abstract T cursorToEntity(Cursor cursor);
    protected abstract ContentValues entityToContentValues(T entity);

    public RepositoryBase(Context context) {
       db = new DbHelper(context).getWritableDatabase();
    }

    private String getWhereClause(){
        return primaryField + " = ?";
    }

    @Override
    public List<T> all() {
        ArrayList<T> list = new ArrayList<>();
        Cursor cursor = db.query(tableName, null, null, null, null, null, null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    list.add(cursorToEntity(cursor));
                }while (cursor.moveToNext());
            }
            cursor.close();
        }

        return list;
    }

    @Override
    public T get(int id) {
        Cursor cursor = db.query(tableName, null, getWhereClause(),
                new String[]{Integer.toString(id)}, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            return cursorToEntity(cursor);
        }

        return null;
    }

    @Override
    public int create(T item) {
        return (int)db.insert(tableName, null, entityToContentValues(item));
    }

    @Override
    public T update(T item) {
        db.update(tableName, entityToContentValues(item), getWhereClause(),
                new String[]{Integer.toString(item.getId())});
        return item;
    }

    @Override
    public void delete(int id) {
        db.delete(tableName, getWhereClause(), new String[]{Integer.toString(id)});
    }
}
