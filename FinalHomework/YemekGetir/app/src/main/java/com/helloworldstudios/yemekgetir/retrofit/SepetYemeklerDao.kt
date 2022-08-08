package com.helloworldstudios.yemekgetir.retrofit

import com.helloworldstudios.yemekgetir.data.entity.CRUDCevap
import com.helloworldstudios.yemekgetir.data.entity.SepetYemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SepetYemeklerDao {

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepetYemekGetir(@Field("kullanici_adi") kullanici_adi : String ) : Call<SepetYemeklerCevap>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepetYemekEkle(@Field("yemek_adi")          yemek_adi : String,
                       @Field("yemek_resim_adi")    yemek_resim_adi : String,
                       @Field("yemek_fiyat")        yemek_fiyat : Int,
                       @Field("yemek_siparis_adet") yemek_siparis_adet : Int,
                       @Field("kullanici_adi")      kullanici_adi : String ) : Call<CRUDCevap>


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepetYemekSil(@Field("sepet_yemek_id") sepet_yemek_id : Int,
                      @Field("kullanici_adi")  kullanici_adi : String ) : Call<CRUDCevap>

}