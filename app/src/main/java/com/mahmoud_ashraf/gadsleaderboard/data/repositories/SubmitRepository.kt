package com.mahmoud_ashraf.gadsleaderboard.data.repositories

import com.mahmoud_ashraf.gadsleaderboard.data.remote.LeadersGateWay
import com.mahmoud_ashraf.gadsleaderboard.domain.repositories.ISubmitRepository

class SubmitRepository : ISubmitRepository{
    override suspend fun submit(
        email: String,
        firstName: String,
        lastName: String,
        projectLink: String
    ): Void {
        return LeadersGateWay.submitEndpoints.submit(email, firstName, lastName, projectLink)
    }

}