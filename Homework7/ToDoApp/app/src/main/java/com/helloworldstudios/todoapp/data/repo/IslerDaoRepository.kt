package com.helloworldstudios.todoapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.helloworldstudios.todoapp.data.entity.Isler
import com.helloworldstudios.todoapp.room.IslerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IslerDaoRepository(var idao: IslerDao) {

    var islerListesi: MutableLiveData<List<Isler>>
    init {
        islerListesi = MutableLiveData()
    }

    fun isleriGetir(): MutableLiveData<List<Isler>>{
        return islerListesi
    }

    fun isKayit(yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniIs = Isler(0, yapilacak_is)
            idao.isEkle(yeniIs)
        }
    }

    fun isGuncelle(yapilacak_id: Int, yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Isler(0, yapilacak_is)
            idao.isGuncelle(guncellenenIs)
        }
    }

    fun isAra(aramaKelimesi: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = idao.isAra(aramaKelimesi)
        }
    }

    fun isSil(yapilacak_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenIs = Isler(yapilacak_id, "")
            idao.isSil(silinenIs)
            tumIsleriAl()
        }
    }

    fun tumIsleriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = idao.tumIsler()
        }
    }
}