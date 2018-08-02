package com.coffietocode.comicapps.comicmania.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.coffietocode.comicapps.comicmania.data.db.dao.DemoDao
import com.coffietocode.comicapps.comicmania.data.model.room.Demo

/**
 * Created by Sadman Sarar on 9/9/17.
 * Database Class including the Dao
 * TODO: Change the database & dao based on what you want
 */

@Database(entities = arrayOf(Demo::class), version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun demoDao(): DemoDao
}
