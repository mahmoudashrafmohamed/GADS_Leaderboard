package com.mahmoud_ashraf.gadsleaderboard.presentation.submit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import com.mahmoud_ashraf.gadsleaderboard.data.repositories.LeadersRepository
import com.mahmoud_ashraf.gadsleaderboard.data.repositories.SubmitRepository
import com.mahmoud_ashraf.gadsleaderboard.presentation.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class SubmitViewModel : ViewModel() {

    private val repository = SubmitRepository()

    private val _submitLiveData = MutableLiveData<Resource<Boolean>>()
    val submitLiveData: LiveData<Resource<Boolean>> = _submitLiveData

     fun submit( email: String,
    firstName: String,
    lastName: String,
    projectLink: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _submitLiveData.postValue(Resource.Loading())
            runCatching {
                repository.submit(email, firstName, lastName, projectLink)
            }.onSuccess { data ->
                _submitLiveData.postValue (Resource.Success(true))
            }.onFailure { throwable ->
                _submitLiveData.postValue(
                    Resource.Error(throwable.localizedMessage ?: "Something wrong happened!")
                )
            }

        }
    }


}