package com.mahmoud_ashraf.gadsleaderboard.data.repositories

import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import com.mahmoud_ashraf.gadsleaderboard.data.remote.LeadersGateWay
import com.mahmoud_ashraf.gadsleaderboard.domain.repositories.ILeadersRepository
import com.mahmoud_ashraf.gadsleaderboard.presentation.utils.Resource
import java.lang.Exception

class LeadersRepository : ILeadersRepository{
    override suspend fun getLearnersLeaders():List<Leader>{
        return  LeadersGateWay.leadersEndpoints.getLearningLeader()
    }

    override suspend fun getSkillsLeaders(): List<Leader> {
       return  LeadersGateWay.leadersEndpoints.getSkillLeader()
    }

}