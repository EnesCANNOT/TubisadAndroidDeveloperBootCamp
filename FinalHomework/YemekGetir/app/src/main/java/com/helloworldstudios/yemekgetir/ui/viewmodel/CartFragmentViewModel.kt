package com.helloworldstudios.yemekgetir.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.data.entity.SepetYemekler
import com.helloworldstudios.yemekgetir.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel @Inject constructor(var yrepo: YemeklerDaoRepository) : ViewModel() {
    var sepettekiYemekListesi = MutableLiveData<List<SepetYemekler>>()
    var sepetIdList = ArrayList<Int>()

    init {
        sepettekiYemekListesi = yrepo.sepettekiYemekleriGetir()
    }

    fun sepettekiYemekleriYukle(kullanici_adi: String) {
        yrepo.sepettekiYemekleriAl(kullanici_adi)
    }

//    fun getYemekTutar(): Double {
//        var price = 0.00
//        sepettekiYemekListesi.value?.forEach {
//            price += (it.yemek_fiyat * it.yemek_siparis_adet).toDouble()
//        }
//        return price
//    }
//
    fun getYemekIdList(): ArrayList<Int> {
        val list  = ArrayList<Int>()
        sepettekiYemekListesi.value?.forEach {
            list.add(it.sepet_yemek_id)
        }
        return list
    }

    fun sepettekiYemekSil(sepet_yemek_id: Int, kullanici_adi: String) {
        yrepo.sepettekiYemekSil(sepet_yemek_id, kullanici_adi)
    }

//    fun tumYemekleriSil(){
//        Log.e("Look", "tumYemekleriSil çalıştı")
//        for (id in sepetIdList){
//            Log.e("LookId", id.toString())
//        }
//
//        sepetIdList.forEach {
//            yrepo.sepettekiYemekSil(it, FirebaseAuth.getInstance().currentUser!!.email.toString())
//        }
//    }
}