package com.forza.team.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamDAO {
    @Query("SELECT * FROM TEAM")
    fun findTeams(): LiveData<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeams(teamEntities: List<TeamEntity>)

    @Query("DELETE FROM TEAM")
    fun deleteTeams()
}
