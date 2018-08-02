package com.coffietocode.comicapps.comicmania

import android.app.Activity
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import com.coffietocode.comicapps.comicmania.di.AppComponent
import com.coffietocode.comicapps.comicmania.di.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Sadman Sarar on 6/21/18.
 */

open class ComicMainaApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }


    companion object {
        lateinit var appComponent: AppComponent
        var app: ComicMainaApp? = null

        fun isNetworkAvailable(): Boolean {
            val connectivityManager = app?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            val activeNetworkInfo = connectivityManager?.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        Stetho.initializeWithDefaults(this)

        try {
            appComponent = DaggerAppComponent.builder()
                    .application(this)
                    .build()

            appComponent.inject(this)
        } catch (ex: Exception) {}

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks() {

            override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
                p0?.let { AndroidInjection.inject(p0) }
            }
        })
    }

    abstract class ActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(p0: Activity?) {
        }

        override fun onActivityResumed(p0: Activity?) {
        }

        override fun onActivityStarted(p0: Activity?) {
        }

        override fun onActivityDestroyed(p0: Activity?) {
        }

        override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
        }

        override fun onActivityStopped(p0: Activity?) {
        }

        override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
        }
    }
}