package com.arnisand.simplereddit.di.component

import android.app.Application
import com.arnisand.simplereddit.di.module.UiModule
import com.arnisand.simplereddit.di.module.AppModule
import com.arnisand.simplereddit.ui.RedditApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        UiModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: RedditApplication)
}
