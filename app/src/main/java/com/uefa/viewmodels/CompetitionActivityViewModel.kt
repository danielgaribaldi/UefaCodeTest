package com.uefa.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uefa.model.UefaTeam
import com.uefa.repositories.CompetitionRepository
import com.uefa.repositories.SuperFakeRepository

class CompetitionActivityViewModel : ViewModel() {

    private val repository: CompetitionRepository = SuperFakeRepository()

    val team: MutableLiveData<UefaTeam> = MutableLiveData()

    fun getTeam() {
        team.value = repository.getTeam()
    }
}


