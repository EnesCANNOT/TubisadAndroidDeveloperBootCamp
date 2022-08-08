package com.helloworldstudios.yemekgetir.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.data.entity.SepetYemekler
import com.helloworldstudios.yemekgetir.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel  @Inject constructor (var yrepo: YemeklerDaoRepository) : ViewModel() {
    var sepetYemeklerListesi = MutableLiveData<List<SepetYemekler>>()

    init {
//        sepetYemekleriYukle(kullanici_adi = "${FirebaseAuth.getInstance().currentUser?.email}")
//        sepetYemeklerListesi = yrepo.sepetiGetir()
        sepetYemekleriYukle()
        sepetYemeklerListesi = yrepo.sepetiGetir()
    }

    fun sil(sepet_yemek_id: Int) {
        yrepo.sepetYemekSil(sepet_yemek_id)
    }

    fun sepetYemekleriYukle() {
        yrepo.tumSepetiGoster()
    }

//    fun sepetYemekleriYukle(kullanici_adi:String) {
//        yrepo.tumSepetYemekleriAl(kullanici_adi)
//    }
}