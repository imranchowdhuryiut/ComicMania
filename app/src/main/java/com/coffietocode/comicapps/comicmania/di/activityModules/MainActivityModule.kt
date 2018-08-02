package com.coffietocode.comicapps.comicmania.di.activityModules

import com.coffietocode.comicapps.comicmania.view.activity.HomeActivity
import com.coffietocode.comicapps.comicmania.view.activity.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample/app/src/main/java/com/android/example/github/di
 */
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeSplashScreenActivity(): SplashScreenActivity

    @ContributesAndroidInjector
    internal abstract fun contributeHomeActivity(): HomeActivity


}