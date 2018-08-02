package com.coffietocode.comicapps.comicmania.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.coffietocode.comicapps.comicmania.data.model.room.Demo;
import java.util.List;

/**
 * Created by Imran Chowdhury on 8/2/2018
 */
@Dao
public abstract class DemoDao extends BaseDao<Demo> {

    @Query("SELECT * from demo")
    public abstract LiveData<List<Demo>> getDemoList();

}
