package com.forza.team.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.forza.api.model.TeamDetail
import com.forza.team.data.TeamsRepository
import javax.inject.Inject

class TeamDetailViewModel @Inject constructor(private val repository: TeamsRepository) :
    ViewModel() {

    fun loadTeamDetail(teamId: Long) {
        repository.loadTeamDetail(teamId)
    }

    fun getTeamDetail(teamId: Long): LiveData<TeamDetail> {
        return repository.getTeamDetail(teamId)
    }
}
