package com.mahmoud_ashraf.gadsleaderboard.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import com.mahmoud_ashraf.gadsleaderboard.data.repositories.LeadersRepository
import com.mahmoud_ashraf.gadsleaderboard.presentation.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val repository = LeadersRepository()

    private val _learnersLeadersLiveData = MutableLiveData<Resource<List<Leader>>>()
    val learnersLeadersLiveData: LiveData<Resource<List<Leader>>> = _learnersLeadersLiveData

    private val _skilledLeadersLiveData = MutableLiveData<Resource<List<Leader>>>()
    val skilledLeadersLiveData: LiveData<Resource<List<Leader>>> = _skilledLeadersLiveData

    init {
        fetchData()
    }

    private fun fetchData() {
        getLearnersLeader()
        getSkillIqLeaders()
    }

    private fun getLearnersLeader() {
        viewModelScope.launch(Dispatchers.IO) {
            _learnersLeadersLiveData.postValue(Resource.Loading())
            runCatching {
                repository.getLearnersLeaders()
            }.onSuccess { data ->
                _learnersLeadersLiveData.postValue (Resource.Success(data))
            }.onFailure { throwable ->
                _learnersLeadersLiveData.postValue(
                    Resource.Error(throwable.localizedMessage ?: "Something wrong happened!")
                )
            }

        }
    }

    private fun getSkillIqLeaders() {
        viewModelScope.launch(Dispatchers.IO) {
            _skilledLeadersLiveData.postValue(Resource.Loading())
            runCatching {
                repository.getSkillsLeaders()
            }.onSuccess { data ->
                _skilledLeadersLiveData.postValue (Resource.Success(data))
            }.onFailure { throwable ->
                _skilledLeadersLiveData.postValue(
                    Resource.Error(throwable.localizedMessage ?: "Something wrong happened!")
                )
            }

        }
    }
}