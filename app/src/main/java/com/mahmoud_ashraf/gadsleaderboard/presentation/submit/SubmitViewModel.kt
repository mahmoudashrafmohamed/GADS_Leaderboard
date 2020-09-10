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
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class SubmitViewModel : ViewModel() {

    private val repository = SubmitRepository()

    private val _submitLiveData = MutableLiveData<Resource<Boolean>>()
    val submitLiveData: LiveData<Resource<Boolean>> = _submitLiveData

    fun submit(
        email: String,
        firstName: String,
        lastName: String,
        projectLink: String
    ) {

        _submitLiveData.postValue(Resource.Loading())

        repository.submit(email, firstName, lastName, projectLink)
            .enqueue(object : retrofit2.Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful)
                        _submitLiveData.postValue(Resource.Success(true))
                    else
                        _submitLiveData.postValue(
                            Resource.Error("Something wrong happened!")
                        )
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    _submitLiveData.postValue(
                        Resource.Error(t.localizedMessage ?: "Something wrong happened!")
                    )
                }
            })
    }

}

