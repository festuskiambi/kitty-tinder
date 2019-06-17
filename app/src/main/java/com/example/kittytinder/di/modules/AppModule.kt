package com.example.kittytinder.di.modules

import android.app.Application
import androidx.room.Room
import com.example.kittytinder.data.source.CatsRepository
import com.example.kittytinder.data.source.ICatsDataSource
import com.example.kittytinder.data.source.local.Database
import com.example.kittytinder.data.source.local.VoteDao
import com.example.kittytinder.data.source.remote.ApiInterface
import com.example.kittytinder.listcats.viewmodel.ListCatsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Festus Kiambi on 6/14/19.
 */
@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    fun provideCatsICatsDataSource(apiInterface: ApiInterface, votesDao: VoteDao): ICatsDataSource{
        return CatsRepository(apiInterface,votesDao)
    }

    @Provides
    fun provideListCatsViewModelFactory(catsDataSource: ICatsDataSource):ListCatsViewModelFactory {
        return ListCatsViewModelFactory(catsDataSource)
    }

    @Provides
    @Singleton
    fun providePostsDatabase(app: Application) = Room.databaseBuilder(
        app, Database::class.java, "votes"
    ).build()

    @Provides
    @Singleton
    fun providePostsDao(database: Database) = database.votesDao()
}