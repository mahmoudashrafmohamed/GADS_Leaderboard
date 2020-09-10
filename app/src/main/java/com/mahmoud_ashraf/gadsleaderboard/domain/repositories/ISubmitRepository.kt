package com.mahmoud_ashraf.gadsleaderboard.domain.repositories

import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import com.mahmoud_ashraf.gadsleaderboard.presentation.utils.Resource

interface ISubmitRepository {
    suspend fun submit( email: String,
                        firstName: String,
                        lastName: String,
                      projectLink: String,) :Void

}