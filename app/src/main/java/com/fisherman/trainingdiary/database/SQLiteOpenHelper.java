package com.fisherman.trainingdiary.database;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

import com.fisherman.trainingdiary.entity.DaoMaster;

import org.greenrobot.greendao.database.Database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SQLiteOpenHelper extends DaoMaster.OpenHelper {

    private static final String dbPath = "/data/data/com.fisherman.trainingdiary/databases";
    private String dbName;
    private AssetManager assetManager;

    public SQLiteOpenHelper(Context context, String name) {
        super(context, name);
        this.dbName = name;
        this.assetManager = context.getAssets();
        try {
            copyDb();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't copy db");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("sqlite");
    }

    @Override
    public void onCreate(Database db) {
        System.out.println("database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("update");
    }

    private void copyDb() throws IOException {
        File file = new File(dbPath);
        if (!file.exists()){
            System.out.println("copy db");
            file.mkdir();
            InputStream inputStream = assetManager.open(dbName);
            OutputStream outputStream = new FileOutputStream(dbPath + File.separatorChar + dbName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
    }
}
