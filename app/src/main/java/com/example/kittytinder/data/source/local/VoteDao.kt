package com.example.kittytinder.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kittytinder.data.Vote

/**
 * Created by Festus Kiambi on 6/17/19.
 */
@Dao
 abstract class VoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertVote(vote :Vote)
}