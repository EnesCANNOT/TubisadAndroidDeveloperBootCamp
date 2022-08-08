package com.helloworldstudios.yemekgetir.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.data.entity.*
import com.helloworldstudios.yemekgetir.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class YemeklerDaoRepository @Inject constructor(var ydao: YemeklerDao) {
    var yemeklerListesi: MutableLiveData<List<Yemekler>>
    var sepetYemekListesi: MutableLiveData<List<SepetYemekler>>

    init {
        yemeklerListesi = MutableLiveData()
        sepetYemekListesi = MutableLiveData()
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun sepettekiYemekleriGetir(): MutableLiveData<List<SepetYemekler>> {
        return sepetYemekListesi
    }

    fun siparisKayit(yemek_adi: String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int, kullanici_adi: String) {
        ydao.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
            .enqueue(object : Callback<CRUDCevap> {
                override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                    val basari = response.body()!!.success
                    val mesaj = response.body()!!.message
                    Log.e("Sipariş Oluştu", "$basari - $mesaj")
                }

                override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                }
            })
    }

    fun sepettekiYemekleriAl(kullanici_adi: String) {
        ydao.sepettekiYemekleriGetir(kullanici_adi).enqueue(object : Callback<SepetYemeklerCevap> {
            override fun onResponse(
                call: Call<SepetYemeklerCevap>?,
                response: Response<SepetYemeklerCevap>
            ) {
                val liste = response.body()!!.sepet_yemekler
                sepetYemekListesi.value = liste
            }
            override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {
                sepetYemekListesi.value = emptyList()
            }
        })
    }

    fun sepettekiYemekSil(sepet_yemek_id: Int, kullanici_adi: String) {
        ydao.sepettekiYemekSil(sepet_yemek_id, kullanici_adi)
            .enqueue(object : Callback<SepetYemeklerCevap> {
                override fun onResponse(
                    call: Call<SepetYemeklerCevap>?,
                    response: Response<SepetYemeklerCevap>
                ) {
                    val basari = response.body()!!.success
                    Log.e("Sipariş silindi", "$basari")
                    sepettekiYemekleriAl(kullanici_adi)
                }
                override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {
                }
            })
    }

    fun tumYemekleriAl() {
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler
                yemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }

    fun sortByDescendingPrice() {
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler

                val sirala =  liste.sortedWith(compareBy { it.yemek_fiyat })
                yemeklerListesi.value = sirala
            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })

    }

    fun sortByAscendingPrice() {

        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler

                val sorted =  liste.sortedWith(compareBy { it.yemek_fiyat })
                val reverselist= sorted.reversed()
                yemeklerListesi.value = reverselist

            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })

    }

    fun sortAlphabeticalA_Z(){
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler

                val sirala =  liste.sortedWith(compareBy { it.yemek_adi })
                yemeklerListesi.value = sirala
            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }

    fun sortAlphabeticalZ_A(){
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler

                val sirala =  liste.sortedWith(compareBy { it.yemek_adi })
                val reverselist= sirala.reversed()
                yemeklerListesi.value = reverselist
            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }

    fun searchFood(aramaKelimesi: String){
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler

                val sonuc =  liste.filter { it.yemek_adi.contains(aramaKelimesi, true) }
                yemeklerListesi.value = sonuc
            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }
}