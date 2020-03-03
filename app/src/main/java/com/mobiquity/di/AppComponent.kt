package com.mobiquity.di

import android.app.Application
import com.mobiquity.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class , AppModule::class, ContributorsModule::class))
interface AppComponent {
    fun inject(app: MyApp)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():AppComponent
    }
}