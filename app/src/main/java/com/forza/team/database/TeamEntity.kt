package com.forza.team.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Team")
data class TeamEntity(
    @PrimaryKey @ColumnInfo(name = "id") val teamId: Long,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "national") val national: Boolean,
    @ColumnInfo(name = "name") val name: String
)