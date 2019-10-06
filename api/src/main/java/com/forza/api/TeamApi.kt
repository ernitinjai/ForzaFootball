package com.forza.api

import com.forza.api.model.Team
import com.forza.api.model.TeamDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TeamApi {
    @GET("/teams/teams.json")
    fun loadTeams(): Call<List<Team>>

    @GET("/teams/{teamId}/team.json")
    fun loadTeamDetail(@Path("teamId") teamId: Long): Call<TeamDetail>
}