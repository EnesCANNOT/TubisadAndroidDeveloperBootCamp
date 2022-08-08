package com.helloworldstudios.yemekgetir.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helloworldstudios.yemekgetir.data.entity.SepetYemekler
import com.helloworldstudios.yemekgetir.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekDetayFragmentViewModel @Inject constructor(var yrepo: YemeklerDaoRepository) : ViewModel() {

    var yemekAdi: String = ""
    var yemekSiparisId:Int = 0
    var sepettekiYemekListesi = MutableLiveData<List<SepetYemekler>>()
    val sepetSayi = MutableLiveData<Int>()

    init {
        sepettekiYemekListesi = yrepo.sepetiGetir()
    }

    fun addToCart(yemek_adi: String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int, kullanici_adi:String){
        yemekAdetGetir { itAdet ->
            siparisIdGetir{itId ->
                oncekiSiparisSil(itId,kullanici_adi)
                yrepo.yemekSepeteEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet,kullanici_adi)
            }
        }
    }

    fun yemekAdetGetir(sepetYemekAdet: (result: Int) -> Unit){
        val liste = sepettekiYemekListesi.value
        val yemekAdet = liste?.filter { it.yemek_adi.contentEquals(yemekAdi) }?.getOrNull(0)?.yemek_siparis_adet?:0
        sepetSayi.value = yemekAdet
        sepetYemekAdet.invoke(yemekAdet)
    }

    fun siparisIdGetir(sepetYemekId: (result: Int) -> Unit){
        val liste = sepettekiYemekListesi.value
        val yemekId = liste?.filter { it.yemek_adi.contains(yemekAdi) }?.getOrNull(0)?.sepet_yemek_id?:0
        sepetYemekId.invoke(yemekId)
    }

    fun oncekiSiparisSil(sepet_yemek_id: Int, kullanici_adi: String){
        yrepo.sepetYemekSil(sepet_yemek_id)
    }

}