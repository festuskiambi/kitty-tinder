package com.example.kittytinder.data.source.local

import androidx.room.Database
import com.example.kittytinder.data.Vote

/**
 * Created by Festus Kiambi on 6/17/19.
 */
@Database(
    entities = [Vote::class], version = 1
)
abstract class Database {
    abstract fun voteDao(): VoteDao
}