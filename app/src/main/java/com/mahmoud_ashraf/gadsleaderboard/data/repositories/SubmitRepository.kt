package com.mahmoud_ashraf.gadsleaderboard.data.repositories

import com.mahmoud_ashraf.gadsleaderboard.data.remote.LeadersGateWay
import com.mahmoud_ashraf.gadsleaderboard.domain.repositories.ISubmitRepository
import retrofit2.Call

class SubmitRepository : ISubmitRepository{
    override  fun submit(
        email: String,
        firstName: String,
        lastName: String,
        projectLink: String
    ): Call<Void> {
        return LeadersGateWay.submitEndpoints.submit(email, firstName, lastName, projectLink)
    }

}