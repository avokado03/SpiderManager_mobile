package com.app.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Хэлпер для собственной
 * sqlite-базы
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "spider.db";
    public static final String DB_PATH = "data/data/spidermanager/databases/";
    public static final int DB_VERSION = 1;
    public static final String TB_USER = "Users";

    private SQLiteDatabase db;
    private Context context;

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
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
     * @throws SQLException
     */
    public void openDB() throws SQLException{
        String dbFullPath = DB_PATH+DB_NAME;
        db = SQLiteDatabase.openDatabase(dbFullPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    /**
     * Создает файл БД на устройстве,
     * если его еще не существует
     * @throws IOException
     */
    public void createDb() throws IOException{
        if (!(checkDbExisting())) {
            this.getReadableDatabase();
            try{
                copyDb();
            }
            catch (IOException ex){
                Log.e("SpiderManager-createDB", ex.getMessage());
            }
        }
    }

    /**
     * Копирует файл БД из ассетов
     * на устройство
     * @throws IOException
     */
    public void copyDb() throws IOException {
        try {
            InputStream inputStream = context.getAssets().open(DB_NAME);
            String dbFullName = DB_PATH + DB_NAME;
            OutputStream outputStream = new FileOutputStream(dbFullName);

            byte[] buffer = new byte[1024];
            int lenght;

            while ((lenght = inputStream.read(buffer)) > 0)
                outputStream.write(buffer, 0, lenght);

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        catch (Exception ex){
            Log.e("SpiderManager - copyDb", ex.getMessage());
        }
    }

    /**
     * Проверяет наличие созданной БД на устройстве
     */
    private boolean checkDbExisting(){
        SQLiteDatabase temp = null;
        String dbPath = DB_PATH + DB_NAME;
        try {
            temp = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        }
        catch (SQLException ex) {
            Log.e("Spider DB checked",ex.getMessage());
        }
        return temp!=null;
    }
}
