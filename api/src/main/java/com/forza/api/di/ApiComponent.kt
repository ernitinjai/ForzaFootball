package com.forza.api.di

import com.forza.api.TeamClient
import com.forza.api.di.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent {
    @Component.Builder
    interface Builder {
        fun apiModule(apiModule: ApiModule): Builder
        fun build(): ApiComponent
    }

    fun inject(client: TeamClient)
}

