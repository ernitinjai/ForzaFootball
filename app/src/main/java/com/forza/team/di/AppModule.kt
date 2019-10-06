package com.forza.team.di

import android.content.Context
import com.forza.team.TeamApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: TeamApplication): Context {
        return application.applicationContext
    }
}