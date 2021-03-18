package com.acharcitox.fruteriabit.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.acharcitox.fruteriabit.daos.FrutaDao;
import com.acharcitox.fruteriabit.entities.Fruta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities =  {Fruta.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract FrutaDao frutaDao();

    private static volatile AppDataBase instance;

    public static final ExecutorService databasewriteExecutor = Executors.newFixedThreadPool(4);

    public static AppDataBase getInstance(final Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "fruteria")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
