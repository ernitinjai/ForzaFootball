package com.forza.team.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TeamEntity::class, TeamDetailEntity::class], version = 1)
abstract class TeamDataBase : RoomDatabase() {
    abstract fun teamDAO(): TeamDAO
    abstract fun teamDetailDAO(): TeamDetailDAO
}