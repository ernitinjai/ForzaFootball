package com.forza.api

import com.forza.api.di.ApiModule
import com.forza.api.di.DaggerApiComponent
import javax.inject.Inject

class TeamClient {

    @Inject
    lateinit var teamApi: TeamApi

    @Inject
    constructor() {
        setupTeamClient()
    }

    private fun setupTeamClient() {
        DaggerApiComponent.builder()
            .apiModule(ApiModule("https://android-exam.s3-eu-west-1.amazonaws.com"))
            .build()
            .inject(this)
    }

    companion object {
        @JvmStatic
        var instance = TeamClient()
    }
}

