package com.mahmoud_ashraf.gadsleaderboard.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LeadersGateWay {
    private val getOkHttpClient: OkHttpClient
        get() {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }

    val leadersEndpoints by lazy {
        Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com")
            .client(getOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LeadersEndpoints::class.java)
    }

    val submitEndpoints by lazy {
        Retrofit.Builder()
            .baseUrl( "https://docs.google.com")
            .client(getOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SubmitEndpoint::class.java)
    }
}

