package com.forza.team.di

import android.content.Context
import androidx.room.Room
import com.forza.team.data.TeamLocalDataSource
import com.forza.team.data.TeamNetworkDataSource
import com.forza.team.data.TeamsRepository
import com.forza.team.database.TeamDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ResourceModule {
    @Provides
    @Singleton
    fun provideTeamsNetworkDataSource(): TeamNetworkDataSource {
        return TeamNetworkDataSource()
    }

    @Provides
    @Singleton
    fun provideTeamsRepository(
        teamsNetworkDataSource: TeamNetworkDataSource,
        teamLocalDataSource: TeamLocalDataSource
    ): TeamsRepository {
        return TeamsRepository(teamsNetworkDataSource, teamLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideTeamsLocalDataSource(teamDatabase: TeamDataBase): TeamLocalDataSource {
        return TeamLocalDataSource(teamDatabase)
    }

    @Provides
    @Singleton
    fun provideTeamsDatabase(context: Context): TeamDataBase {
        return Room.databaseBuilder(context, TeamDataBase::class.java, "teams.db").build()
    }

}