package com.forza.team.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.forza.team.ui.viewmodel.TeamDetailViewModel
import com.forza.team.ui.viewmodel.TeamsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TeamsViewModel::class)
    abstract fun bindTeamsViewModel(teamsViewModel: TeamsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TeamDetailViewModel::class)
    abstract fun bindTeamDetailViewModel(teamDetailViewModel: TeamDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}