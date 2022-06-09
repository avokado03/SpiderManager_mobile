package com.app.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Хэлпер для собственной
 * sqlite-базы
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "spiders.db";
    public static final int DB_VERSION = 1;
    private final String dbPath;
    private final File dbFile;

    private SQLiteDatabase db;
    private final Context context;

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        String p = context.getPackageName();
        this.dbPath = "/data/data/" + p + "/databases/";
        this.dbFile = new File(getDbPath());
    }

    /**
    * Событие создания БД
    */
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    /**
    * Событие, возникающее при обновлении
    * версии БД
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            createDb();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Закрывает все открытые соединения
    */
    @Override
    public synchronized void close(){
        if(db!=null)
            db.close();
        super.close();
    }

    /**
     * Открывает соединение с БД
     */
    public void openDB() throws SQLException{
        String dbFullPath = getDbPath();
        db = SQLiteDatabase.openDatabase(dbFullPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    /**
     * Создает файл БД на устройстве,
     * если его еще не существует
     */
    public void createDb() throws IOException{
        boolean dbCheck = dbFile.exists();
        if(!dbCheck){
            try {
                copyDb();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Копирует файл БД из ассетов
     * на устройство
     */
    public void copyDb() throws IOException {
        try {
            InputStream inputStream = context.getAssets().open(DB_NAME);
            String dbFullPath = getDbPath();
            if(!dbFile.exists())
                dbFile.mkdir();
            FileOutputStream outputStream = new FileOutputStream(dbFullPath);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0)
                outputStream.write(buffer, 0, length);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        catch (Exception ex){
            Log.e("SpiderManager - copyDb", ex.getMessage());
        }
    }

    /**
     * @return Возвращает
     * путь к БД
     */
    private String getDbPath(){
        return dbPath + DB_NAME;
    }
}
