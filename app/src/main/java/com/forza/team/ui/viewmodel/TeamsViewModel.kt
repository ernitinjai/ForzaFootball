package com.forza.team.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.forza.api.model.Team
import com.forza.team.data.TeamsRepository
import javax.inject.Inject

class TeamsViewModel @Inject constructor(private val repository: TeamsRepository) : ViewModel() {

    fun loadTeams() {
        repository.loadTeams()
    }

    fun getTeams(): LiveData<List<Team>> {
        return repository.getTeams()
    }
}