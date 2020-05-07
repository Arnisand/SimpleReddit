package com.arnisand.simplereddit.di.module

import com.arnisand.simplereddit.ui.main.MainActivity
import com.arnisand.simplereddit.ui.main.TopArticlesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeTopArticlesFragment(): TopArticlesFragment
}