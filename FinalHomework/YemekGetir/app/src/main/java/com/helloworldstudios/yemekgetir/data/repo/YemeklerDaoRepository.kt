package com.helloworldstudios.yemekgetir.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.data.entity.*
import com.helloworldstudios.yemekgetir.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository(var ydao: YemeklerDao) {
    var yemeklerListesi : MutableLiveData<List<Yemekler>>
    var sepetListesi : MutableLiveData<List<SepetYemekler>>

    init {
        yemeklerListesi = MutableLiveData()
        sepetListesi = MutableLiveData()
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun sepetiGetir() : MutableLiveData<List<SepetYemekler>> {
        return sepetListesi
    }

    fun tumSepetYemekleriAl(kullanici_adi: String) {
        ydao.sepetGoster(kullanici_adi).enqueue(object: Callback<SepetYemeklerCevap> {
            override fun onResponse(call: Call<SepetYemeklerCevap>?, response: Response<SepetYemeklerCevap>) {
                val sepetListe = response.body()!!.sepet_yemekler
                sepetListesi.value = sepetListe
            }

            override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {}
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


    fun yemekSepeteEkle(yemek_adi:String, yemek_resim_adi:String, yemek_fiyat:Int, yemek_siparis_adet:Int, kullanici_adi:String){
        ydao.sepetYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object :
            Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                val basari = response.body()!!.success
                val mesaj = response.body()!!.message
                Log.e("Yemek sepete ekle", "$basari - $mesaj")
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun sepetYemekSil(sepet_yemek_id:Int){
        ydao.sepettenSil(sepet_yemek_id,FirebaseAuth.getInstance().currentUser!!.email.toString()).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                val basari = response.body()!!.success
                val mesaj = response.body()!!.message
                Log.e("Yemek sepete ekle", "$basari - $mesaj")
                tumSepetiGoster()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun tumSepetiGoster(){
        ydao.sepetGoster(FirebaseAuth.getInstance().currentUser!!.email.toString()).enqueue(object: Callback<SepetYemeklerCevap> {
            override fun onResponse(call: Call<SepetYemeklerCevap>?, response: Response<SepetYemeklerCevap>) {
                Log.e("Look", response!!.body().toString())
                if (response.body() != null){
                    val liste = response.body()!!.sepet_yemekler
                    sepetListesi.value = liste
                } else{
                    sepetListesi.value = mutableListOf()//***
                }


//                if(sepetListesi.value != null){
//                    if (response.body() != null){
//                        sepetListesi.value!!.filter {
//                            it !in response!!.body()!!.sepet_yemekler
//                        }
//                    }
//                }

            }

            override fun onFailure(call: Call<SepetYemeklerCevap>, t: Throwable) {}
        })
    }
}