package com.acharcitox.fruteriabit.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.acharcitox.fruteriabit.entities.Fruta;

import java.util.List;

@Dao
public interface FrutaDao {

    @Query("SELECT * FROM fruta")
    LiveData<List<Fruta>> getAll();

    @Insert
    void insert(Fruta fruta);

    @Update
    void update(Fruta fruta);

    @Delete
    void delete(Fruta fruta);

    @Query("SELECT * FROM Fruta where nombre like :nombre")
    Fruta findByNombre(String nombre);

    @Query("SELECT * FROM Fruta where id = :id")
    Fruta findById(int id);
}
