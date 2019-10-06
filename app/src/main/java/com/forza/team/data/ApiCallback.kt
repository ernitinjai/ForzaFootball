package com.forza.team.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class ApiCallback<T> : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            val apiResponse = response.body()
            if (apiResponse != null) {
                onSuccess(apiResponse)
            }
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {}

    abstract fun onSuccess(apiResponse: T)
}