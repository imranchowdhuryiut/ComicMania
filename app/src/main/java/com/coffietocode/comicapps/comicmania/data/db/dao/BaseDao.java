package com.coffietocode.comicapps.comicmania.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

@Dao
abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void save(List<T> data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void save(T... data);

    @Delete
    public abstract void delete(T... data);

    @Delete
    public abstract void delete(List<T> data);

}

