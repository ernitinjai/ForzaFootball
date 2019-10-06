package com.forza.team.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.forza.team.database.TeamDataBase
import com.forza.team.database.TeamDetailEntity
import com.forza.team.database.TeamEntity

class TeamLocalDataSource(private val database: TeamDataBase) {
    fun findTeams(): LiveData<List<TeamEntity>> {
        return database.teamDAO().findTeams()
    }

    fun insertTeams(teams: List<TeamEntity>) {
        AsyncTask.execute {
            database.teamDAO().insertTeams(teams)
        }
    }

    fun insertTeamDetail(teamDetail: TeamDetailEntity) {
        AsyncTask.execute {
            database.teamDetailDAO().insertTeamDetail(teamDetail)
        }
    }

    fun deleteTeams() {
        AsyncTask.execute {
            database.teamDAO().deleteTeams()
        }
    }

    fun findTeamDetail(teamId: Long): LiveData<TeamDetailEntity> {
        return database.teamDetailDAO().getDetail(teamId)
    }
}
