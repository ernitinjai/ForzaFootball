package com.forza.team.data

import TeamDetailEntityMapper
import TeamEntityMapper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.forza.api.model.Team
import com.forza.api.model.TeamDetail
import com.forza.team.database.TeamDetailEntity
import com.forza.team.database.TeamEntity
import java.util.stream.Collectors

class TeamsRepository(
    private val teamNetworkDataSource: TeamNetworkDataSource,
    private val teamLocalDataSource: TeamLocalDataSource
) {
    var teamDetail = MutableLiveData<TeamDetail>()

    fun getTeams(): LiveData<List<Team>> {
        val teamEntities = teamLocalDataSource.findTeams()
        return Transformations.map(teamEntities) { entities -> toVOs(entities) }
    }

    fun getTeamDetail(teamId: Long): LiveData<TeamDetail> {
        val teamDetailEntity = teamLocalDataSource.findTeamDetail(teamId)
        return Transformations.map(teamDetailEntity) { detailEntity ->
            TeamDetailEntityMapper.toVO(
                detailEntity, teamId
            )
        }
    }

    fun loadTeams() {
        return teamNetworkDataSource.loadTeams(object : ApiCallback<List<Team>>() {
            override fun onSuccess(theTeams: List<Team>) {
                teamLocalDataSource.deleteTeams()
                teamLocalDataSource.insertTeams(toEntities(theTeams))
            }
        })
    }

    fun loadTeamDetail(teamId: Long) {
        teamDetail = MutableLiveData()
        return teamNetworkDataSource.loadTeamDetail(teamId, object : ApiCallback<TeamDetail>() {
            override fun onSuccess(detail: TeamDetail) {
                teamLocalDataSource.insertTeamDetail(
                    TeamDetailEntityMapper.toEntity(
                        detail,
                        teamId
                    )
                )
            }
        })
    }

    private fun toVOs(entities: List<TeamEntity>): List<Team> {
        return entities.stream().map { teamEntity: TeamEntity -> TeamEntityMapper.toVO(teamEntity) }
            .collect(Collectors.toList())
    }

    private fun toEntities(teams: List<Team>): List<TeamEntity> {
        return teams.stream().map { team: Team -> TeamEntityMapper.toEntity(team) }
            .collect(Collectors.toList())
    }
}
