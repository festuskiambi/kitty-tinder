package com.example.kittytinder

import android.app.Activity
import android.app.Application
import com.example.kittytinder.di.components.DaggerAppComponent
import com.example.kittytinder.di.modules.AppModule
import com.example.kittytinder.di.modules.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Festus Kiambi on 6/14/19.
 */
class KittyTinderApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule())
            .build().inject(this)
    }
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}