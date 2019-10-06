package com.forza.team.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TeamDetailDAO {
    @Insert
    fun insertTeamDetail(teamDetailEntity: TeamDetailEntity)

    @Query("SELECT * FROM TeamDetail WHERE teamId=:teamId")
    fun getDetail(teamId: Long): LiveData<TeamDetailEntity>
}
