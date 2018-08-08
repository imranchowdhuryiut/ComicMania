package com.coffietocode.comicapps.comicmania.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.coffietocode.comicapps.comicmania.data.db.AppDb
import com.coffietocode.comicapps.comicmania.data.db.dao.DemoDao
import com.coffietocode.comicapps.comicmania.data.network.retrofit.LiveDataCallAdapterFactory
import com.coffietocode.comicapps.comicmania.data.network.retrofit.WebService
import com.coffietocode.comicapps.comicmania.view.dialog.DialogHandler
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample/app/src/main/java/com/android/example/github/di
 */
@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    companion object {
        const val BASE_URL = ""
        const val APP_DB = "comic_mania.db"
        const val APP_SP = "COMIC_MANIA"
    }

    @Singleton
    @Provides
    fun provideNetworkService(): WebService {

        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addNetworkInterceptor(StethoInterceptor())

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(okHttpBuilder.build())
            .build()
            .create(WebService::class.java)
    }

    @Singleton
    @Provides
    fun providesPrefRepository(app: Context): SharedPreferences {

        return app.applicationContext.getSharedPreferences(APP_SP, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun providesContext(app: Application): Context {

        return app.applicationContext
    }


    @Singleton
    @Provides
    fun provideDb(app: Application): AppDb {
        return Room.databaseBuilder(app, AppDb::class.java, APP_DB)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRepoDao(db: AppDb): DemoDao {
        return db.demoDao()
    }

    @Provides
    fun provideDialogHandler(): DialogHandler {
        return DialogHandler()
    }

}