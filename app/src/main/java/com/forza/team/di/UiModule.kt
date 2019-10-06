package com.forza.team.di

import com.forza.team.ui.team.TeamActivity
import com.forza.team.ui.team.TeamDetailFragment
import com.forza.team.ui.team.TeamsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun bindTeamActivity(): TeamActivity

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindTeamsFragment(): TeamsFragment

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindTeamDetailFragment(): TeamDetailFragment
}