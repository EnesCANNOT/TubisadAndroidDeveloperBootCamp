package com.helloworldstudios.yemekgetir.retrofit

import com.helloworldstudios.yemekgetir.data.entity.CRUDCevap
import com.helloworldstudios.yemekgetir.data.entity.SepetYemeklerCevap
import com.helloworldstudios.yemekgetir.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.*

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepetYemekEkle(@Field("yemek_adi") yemek_adi:String,
                       @Field("yemek_resim_adi") yemek_resim_adi:String,
                       @Field("yemek_fiyat") yemek_fiyat:Int,
                       @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                       @Field("kullanici_adi") kullanici_adi:String) : Call<CRUDCevap>


    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepetGoster(@Field("kullanici_adi") kullanici_adi: String) : Call<SepetYemeklerCevap>


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepettenSil(@Field("sepet_yemek_id") sepet_yemek_id: Int,
                    @Field("kullanici_adi") kullanici_adi: String) : Call<CRUDCevap>
}