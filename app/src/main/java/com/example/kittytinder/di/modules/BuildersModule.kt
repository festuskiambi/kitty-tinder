package com.example.kittytinder.di.modules

import com.example.kittytinder.listcats.ui.ListCatsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Festus Kiambi on 6/14/19.
 */
@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun contibuteListCatActivity(): ListCatsActivity
}