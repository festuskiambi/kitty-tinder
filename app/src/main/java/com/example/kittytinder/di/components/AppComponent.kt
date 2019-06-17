package com.example.kittytinder.di.components

import com.example.kittytinder.KittyTinderApplication
import com.example.kittytinder.di.modules.AppModule
import com.example.kittytinder.di.modules.BuildersModule
import com.example.kittytinder.di.modules.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Festus Kiambi on 6/14/19.
 */
@Singleton
@Component(
    modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class, NetModule::class]
)
interface AppComponent {

 fun inject(app: KittyTinderApplication)
}