package com.forza.team.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TeamDetail", foreignKeys =
    [(ForeignKey(
        entity = TeamEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("teamId"),
        onDelete = ForeignKey.CASCADE
    ))]
)
data class TeamDetailEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Long? = null,
    @ColumnInfo(name = "badgeUrl") val badgeUrl: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "teamId") val teamId: Long
)