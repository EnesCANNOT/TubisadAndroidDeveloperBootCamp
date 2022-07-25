package com.helloworldstudios.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.helloworldstudios.todoapp.data.repo.IslerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor (var irepo: IslerDaoRepository) : ViewModel() {

    fun kayit(yapilacak_is: String){
        irepo.isKayit(yapilacak_is)
    }
}