package com.helloworldstudios.yemekgetir.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helloworldstudios.yemekgetir.data.entity.Yemekler
import com.helloworldstudios.yemekgetir.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(var yrepo: YemeklerDaoRepository) :
    ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemeklerYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }

    fun yemeklerYukle() {
        yrepo.tumYemekleriAl()
    }

    fun sortByDescendingPrice(){
        yrepo.sortByDescendingPrice()
    }

    fun sortByAscendingPrice(){
        yrepo.sortByAscendingPrice()
    }

    fun sortA_Z(){
        yrepo.sortAlphabeticalA_Z()
    }

    fun sortZ_A(){
        yrepo.sortAlphabeticalZ_A()
    }

    fun ara(sonuc : String) {
        yrepo.searchFood(sonuc)
    }
}

/*
@HiltViewModel
class HomeFragmentViewModel @Inject constructor(var yrepo: YemeklerDaoRepository) : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }

    fun yemekleriYukle(){
        yrepo.yemekleriGetir()
    }

    fun sortByDescendingPrice(){
        yrepo.sortByDescendingPrice()
    }

    fun sortByAscendingPrice(){
        yrepo.sortByAscendingPrice()
    }

    fun sortA_Z(){
        yrepo.sortAlphabeticalA_Z()
    }

    fun sortZ_A(){
        yrepo.sortAlphabeticalZ_A()
    }

    fun ara(sonuc : String) {
        yrepo.searchFood(sonuc)
    }
}*/