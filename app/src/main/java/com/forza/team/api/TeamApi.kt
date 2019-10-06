package com.forza.team.api

import com.forza.api.TeamClient
import com.forza.api.model.Team
import com.forza.api.model.TeamDetail
import retrofit2.Callback

object TeamApi {
    @JvmStatic
    fun loadTeams(callback: Callback<List<Team>>) {
        val call = TeamClient.instance.teamApi.loadTeams()
        call.enqueue(callback)
    }

    @JvmStatic
    fun loadTeamDetail(id: Long, callback: Callback<TeamDetail>) {
        val call = TeamClient.instance.teamApi.loadTeamDetail(id)
        call.enqueue(callback)
    }
}