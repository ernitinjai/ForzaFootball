package com.forza.team.data

import com.forza.api.model.Team
import com.forza.api.model.TeamDetail
import com.forza.team.api.TeamApi
import retrofit2.Callback

class TeamNetworkDataSource {

    fun loadTeams(callback: Callback<List<Team>>) {
        TeamApi.loadTeams(callback)
    }

    fun loadTeamDetail(teamId: Long, callback: Callback<TeamDetail>) {
        TeamApi.loadTeamDetail(teamId, callback)
    }
}