package com.acharcitox.fruteriabit.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.acharcitox.fruteriabit.daos.FrutaDao;
import com.acharcitox.fruteriabit.database.AppDataBase;
import com.acharcitox.fruteriabit.entities.Fruta;

import java.util.List;

public class FrutaRepository {
    private FrutaDao frutaDao;

    private LiveData<List<Fruta>> frutas;

    public FrutaRepository(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        frutaDao = db.frutaDao();
        frutas = frutaDao.getAll();
    }

    public LiveData<List<Fruta>> getFrutas() {
        return  frutas;
    }

    public void insert(Fruta fruta) {
        AppDataBase.databasewriteExecutor.execute(() -> {
            frutaDao.insert(fruta);
        });
    }
}
