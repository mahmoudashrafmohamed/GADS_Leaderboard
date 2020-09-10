package com.mahmoud_ashraf.gadsleaderboard.domain.repositories

import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import com.mahmoud_ashraf.gadsleaderboard.presentation.utils.Resource

interface ILeadersRepository {
    suspend fun getLearnersLeaders() : List<Leader>

    suspend fun getSkillsLeaders() : List<Leader>
}