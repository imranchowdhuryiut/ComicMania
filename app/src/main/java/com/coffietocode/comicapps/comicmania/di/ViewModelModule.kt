package com.coffietocode.comicapps.comicmania.di

import android.arch.lifecycle.ViewModelProvider
import com.coffietocode.comicapps.comicmania.view.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample/app/src/main/java/com/android/example/github/di
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}