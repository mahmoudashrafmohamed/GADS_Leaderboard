package com.mahmoud_ashraf.gadsleaderboard.data.remote

import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import retrofit2.http.GET

interface LeadersEndpoints {
    @GET("/api/hours")
    suspend fun getLearningLeader() : List<Leader>

    @GET("/api/skilliq")
    suspend fun getSkillLeader() : List<Leader>
}