package com.example.theaudiodb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theaudiodb.model.repository.LovedRepository
import com.example.theaudiodb.model.repository.LovedRepositoryResult
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class LovedViewModel(
    private val repository: LovedRepository
) : ViewModel(), KoinComponent {

    private val _lovedList = MutableLiveData<LovedViewModelResult>()
    val lovedList: LiveData<LovedViewModelResult> get() = _lovedList

    fun mostLovedUpdate() {
        viewModelScope.launch {
            when (val repositoryStatus = repository.getMostLoved()) {
                LovedRepositoryResult.Error -> {
                    _lovedList.postValue(LovedViewModelResult.Error)
                }
                is LovedRepositoryResult.Success -> {
                    _lovedList.postValue(LovedViewModelResult.Success(repositoryStatus.lovedItem))
                }
            }
        }
    }
}